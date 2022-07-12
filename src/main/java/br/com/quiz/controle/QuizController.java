package br.com.quiz.controle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.model.dao.AplicacaoQuizDao;
import br.com.quiz.model.dao.AplicacaoQuizDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.QuizDao;
import br.com.quiz.model.dao.QuizDaoImpl;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "quizC")
@ViewScoped
public class QuizController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Logger logger = LoggerFactory.logger(getClass());

    private QuizDao quizDao;
    private Quiz quiz;
    private Quiz quizModal;
    private List<Pergunta> perguntas = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();
    private DataModel<Pergunta> modelperguntas;
    private AplicacaoQuizDao aplicacaoQuizDao;
    private Pergunta perguntaSelecionada;
    private AplicacaoQuiz aplicacaoQuiz;
    private Pergunta pergunta;
    private Quiz quizEdit;

//    private static Quiz quizSelecaoEdicao;
    
    private Session sessao;
    private String fluxo;
    private String fluxoFinal;
    public static Long idQuiz;
    public static Long idAplicacaoQuiz;

    public QuizController() {
        if (quiz == null) {
            quiz = new Quiz();
        }
        quizDao = new QuizDaoImpl();
        buscaQuizBanco();
        populaQuizzesPublicos();
    }

    /**
     * Retira questao da modal de visualizar Quiz
     *
     * @param pergunta
     */
    public void retiraQuestaoVisualizacao() {
        logger.info("método - retiraQuestaoVisualizacao()");
        perguntas.remove(perguntaSelecionada);
        logger.info("lista tem : " + perguntas.size());

    }

    public void buscaQuizBanco() {
        logger.info("método - buscaQuizBanco()");

        try {
            sessao = HibernateUtil.abrirSessao();
            quizzes = quizDao.buscarQuizPorUsuario(sessao, LoginController.usuarioSessao().getId());
            logger.info(quizzes);

        } catch (HibernateException e) {
            logger.error("Erro ao salvar - " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    List<String> emailList;

    public void cadastraAplicacaoQuiz(DataModel<String> emails) {
        logger.info("método - cadastraAplicacaoQuiz()");
        emailList = new ArrayList<>();
        if (emails == null) {
            Mensagem.erro("Não há emails para enviar!");
        } else {
            try {
                emails.forEach(email -> emailList.add(email));
                aplicacaoQuizDao = new AplicacaoQuizDaoImpl();
                sessao = HibernateUtil.abrirSessao();
                aplicacaoQuiz = new AplicacaoQuiz();
                aplicacaoQuiz.setDataAplicacao(new Date());
                aplicacaoQuiz.setQuiz(quizDao.pesquisarPorId(idQuiz, sessao));
                aplicacaoQuiz.setUsuarioAplicador(LoginController.usuarioSessao());
                aplicacaoQuiz.setEmails(new HashSet<>(emailList));
                aplicacaoQuizDao.salvarOuAlterar(aplicacaoQuiz, sessao);
                idAplicacaoQuiz = aplicacaoQuiz.getId();
                logger.info("idAplicacaoQuiz -> " + idAplicacaoQuiz);
                EmailConvidadoController emailController = new EmailConvidadoController();
                emailController.enviaEmail();
                Mensagem.sucesso(defineFluxoFinalizar());
            } catch (Exception e) {
                logger.error("Erro ao salvar aplicação quiz - " + e.getMessage());
            } finally {
                sessao.close();
                emails = null;
                emailList = null;
            }
        }

    }

    public String defineFluxoFinalizar() throws IOException {
        logger.info("entrou no defineFluxoFinalizar()");

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/inicio.xhtml");
        if (!emailList.isEmpty()) {
            this.fluxoFinal = String.valueOf(ec);
            Mensagem.sucesso("Email enviado com sucesso!");
        } else {
            this.fluxoFinal = "";
        }
        return fluxoFinal;

    }

//	public void defineFluxoFinalizar() throws IOException {
//		logger.info("entrou no defineFluxoFinalizar()");
//		String pageDestino = "";
//		if (!emailList.isEmpty()) {
//			pageDestino = "/inicio.xhtml";
//		} else {
//			pageDestino = "/final.xhtml";
//		}
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		ec.redirect(ec.getRequestContextPath() + pageDestino);
//	}
    public void incluiPergunta(Pergunta pergunta) {
        logger.info("método - incluiPergunta()");

        try {
            if (null != pergunta.getId() && validaQuestaoRepetida(pergunta)) {
                perguntas.add(pergunta);
                modelperguntas = new ListDataModel<>(perguntas);
                logger.info("lista tem : " + perguntas.size());
            }

        } catch (HibernateException e) {
            logger.error("Erro ao incluiPergunta - " + e.getMessage());
        }
    }

    private boolean validaQuestaoRepetida(Pergunta pergunta) {
    	logger.info("método - validaQuestaoRepetida()");
		boolean questaoRepetida = true;
		if (perguntas.contains(pergunta)) {
			questaoRepetida = false;
			Mensagem.erro("Pergunta já foi adicionada ao quiz!");
		}
		return questaoRepetida;
	}

	// Adiciona idQuiz escolhido para aplicacao no Explora Conteudo
    public String adicionaQuizEscolhido(Long idQuizSelecionado) {
        logger.info("método - adicionaQuizEscolhido()");
        idQuiz = idQuizSelecionado;
        return "/logado/final?faces-redirect=true";

    }

    private void populaQuizzesPublicos() {
        logger.info("método - populaQuizzesPublicos()");
        try {
            sessao = HibernateUtil.abrirSessao();
            quizzes = quizDao.buscaQuizzesPublicos(LoginController.usuarioSessao(), sessao);

        } catch (Exception e) {
            logger.info("Erro - " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    /* * CRUD * */
    public String salvarQuiz() {
        logger.info("método - salvarQuiz()");

        try {
            sessao = HibernateUtil.abrirSessao();
            quiz.setUsuarioProprietario(LoginController.usuarioSessao());
            if (preparaQuiz()) {
                quizDao.salvarOuAlterar(quiz, sessao);
                idQuiz = quiz.getId();
            }
            defineFluxo();

        } catch (HibernateException e) {
            logger.error("Erro ao salvar - " + e.getMessage());
        } finally {
            sessao.close();
        }
        return "/final.xhtml?faces-redirect=true";
    }

    private boolean preparaQuiz() {
        logger.info("método - preparaQuiz()");

        boolean quizValido = false;
        quiz.setPerguntas(perguntas);
        if (null == quiz.getPerguntas() || quiz.getPerguntas().isEmpty()) {
            Mensagem.erro("Nenhuma questão ao quiz foi adicionada!");
            logger.error("Erro ao preparaQuiz - lista de perguntas vazia");

        } else if (quiz.getPerguntas().size() < 2) {
            Mensagem.erro("É necessário inserir no mínimo duas questões ao quiz!");
            logger.error("Erro ao preparaQuiz - lista de perguntas vazia");

        } else if (null == quiz.getTitulo() || quiz.getTitulo().isEmpty()) {
            Mensagem.erro("Favor incluir um título no quiz!");
            logger.error("Erro ao preparaQuiz - quiz sem título");

        } else {
            Date criacao = new Date(System.currentTimeMillis());
            quiz.setDataCriacao(criacao);
            quiz.setCategorias(Set.of(perguntas.get(0).getSubCategoria().getCategoria()));
            quizValido = true;
        }
        return quizValido;
    }

    public String defineFluxo() {
        logger.info("entrou no defineFluxo()");
        if (quiz.getPerguntas().size() < 1 || (null == quiz.getTitulo() || quiz.getTitulo().isEmpty())) {
            this.fluxo = "";
        } else {
            this.fluxo = "final";
        }
        return fluxo;
    }

    public void pesquisarQuizElaboradoPeloUsuario() {
        logger.info("entrou no pesquisarQuizConstruidoPeloUsuario()");

        Long idUsuarioLogado = LoginController.usuarioSessao().getId();

        try {
            sessao = HibernateUtil.abrirSessao();
            quizzes = quizDao.buscarQuizPorUsuario(sessao, idUsuarioLogado);
        } catch (HibernateException e) {
            logger.error("Erro ao pesquisar quiz elaborado pelo usuario: " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    public void pesquisaQuizPorId(Long idQuiz) {
        try {
            sessao = HibernateUtil.abrirSessao();
            List<Quiz> quizBd = quizDao.pesquisarPorIdQuiz(sessao, idQuiz);
            quiz = quizBd.get(0);
            logger.info("entrou no pesquisaQuizPorId()" + quiz);
        } catch (HibernateException e) {
            logger.error("Erro ao pesquisar quiz elaborado pelo usuario: " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    public void incluiPerguntaQuiz(Pergunta pergunta) {
        logger.info("método - incluiPergunta()");
        try {
            if (null != pergunta.getId() && validarPerguntaRepetida(pergunta)) {
                quiz.getPerguntas().add(pergunta);
                logger.info("lista tem : " + quiz.getPerguntas().size());
            }

        } catch (HibernateException e) {
            logger.error("Erro ao incluiPergunta - " + e.getMessage());
        }
    }

    private boolean validarPerguntaRepetida(Pergunta pergunta) {
        for (int i = 0; i < quiz.getPerguntas().size(); i++) {
            if (pergunta.getId() == quiz.getPerguntas().get(i).getId()) {
                return false;
            }
        }
        return true;
    }

    public String pesquisaQuizEdita(Long id) {
        pesquisaQuizPorId(id);
        return "editaQuiz";
    }

    public void excluirPergunta(Pergunta pergunta) {
        quiz.getPerguntas().removeIf(p -> p.getId() == pergunta.getId());

    }

    public void editarQuiz(Long id) throws IOException {
        logger.info("método - editarQuiz()");
        try {
            if (desativaQuiz(id)) {
                sessao = HibernateUtil.abrirSessao();
                quiz.setUsuarioProprietario(LoginController.usuarioSessao());
                quiz.setStatusAtivo(true);
                quiz.setId(null);
                
                quizDao.salvarOuAlterar(quiz, sessao);

            }
        } catch (HibernateException e) {
            logger.error("Erro ao salvar - " + e.getMessage());
        } finally {
            sessao.close();
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("/quiz/Perfil/perfil.xhtml");
    }    
    
    public boolean desativaQuiz(Long id) {
        sessao = HibernateUtil.abrirSessao();
        boolean result = quizDao.setStatusAtivoFalse(sessao, id);
        sessao.close();
        return result;
    }
    
    public void pesquisaQuizPorIdModal(Long idQuiz) {
        quizModal = null;
        try {
            sessao = HibernateUtil.abrirSessao();
            List<Quiz> quizBd = quizDao.pesquisarPorIdQuiz(sessao, idQuiz);
            quizModal = quizBd.get(0);
            logger.info("entrou no pesquisaQuizPorIdModal()" + quizModal);
        } catch (HibernateException e) {
            logger.error("Erro ao pesquisar quiz elaborado pelo usuario: " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    public String excluir(Long idQuiz) throws IOException {
        try {
             sessao = HibernateUtil.abrirSessao();
             quizModal.setStatusAtivo(false);
             quizDao.salvarOuAlterar(quizModal, sessao);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/quiz/Perfil/perfil.xhtml");
        } finally {
              sessao.close();
        }
        return "";    
    }
    

    /* * GETTERS AND SETTERS * */
    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Pergunta> getPerguntas() {
        if (perguntas == null) {
            perguntas = new ArrayList<>();
        }
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public Pergunta getPergunta() {
        if (pergunta == null) {
            pergunta = new Pergunta();
        }
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public String getFluxo() {
        return fluxo;
    }

    public void setFluxo(String fluxo) {
        this.fluxo = fluxo;
    }

    public DataModel<Pergunta> getModelperguntas() {
        return modelperguntas;
    }

    public void setModelperguntas(DataModel<Pergunta> modelperguntas) {
        this.modelperguntas = modelperguntas;
    }

    public Pergunta getPerguntaSelecionada() {
        return perguntaSelecionada;
    }

    public void setPerguntaSelecionada(Pergunta perguntaSelecionada) {
        this.perguntaSelecionada = perguntaSelecionada;
    }

    public AplicacaoQuiz getAplicacaoQuiz() {
        if (null == aplicacaoQuiz) {
            aplicacaoQuiz = new AplicacaoQuiz();
        }
        return aplicacaoQuiz;
    }

    public void setAplicacaoQuiz(AplicacaoQuiz aplicacaoQuiz) {
        this.aplicacaoQuiz = aplicacaoQuiz;
    }

    public static Long getIdAplicacaoQuiz() {
        return idAplicacaoQuiz;
    }

    public String getFluxoFinal() {
        return fluxoFinal;
    }

    public Quiz getQuizEdit() {
        if (null == quizEdit) {
            quizEdit = new Quiz();
        }
        return quizEdit;
    }

    public void setQuizEdit(Quiz quizEdit) {
        this.quizEdit = quizEdit;
    }

    public Quiz getQuizModal() {
        if (null == quizModal) {
            quizModal = new Quiz();
        }
        return quizModal;
    }

    public void setQuizModal(Quiz quizModal) {
        this.quizModal = quizModal;
    }
    
    
}
