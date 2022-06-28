package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    private List<Pergunta> perguntas = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();
    private DataModel<Pergunta> modelperguntas;
    private Pergunta perguntaSelecionada;
    private AplicacaoQuiz aplicacaoQuiz;
    private AplicacaoQuizDao aplicacaoQuizDao;
    private Pergunta pergunta;

    private Session sessao;
    private String fluxo;
    public static Long idQuiz;
    public static Long idAplicacaoQuiz;

    public QuizController() {
        if (quiz == null) {
            quiz = new Quiz();
        }
        quizDao = new QuizDaoImpl();
        buscaQuizBanco();
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
            quizzes = quizDao.buscarQuizPorUsuario(sessao, 1L);
            logger.info(quizzes);

        } catch (HibernateException e) {
            logger.error("Erro ao salvar - " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    public void cadastraAplicacaoQuiz(DataModel<String> emails) {
        logger.info("método - cadastraAplicacaoQuiz()");
        List<String> emailList = new ArrayList<>();
        emails.forEach(email -> emailList.add(email));

        try {
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
           

        } catch (Exception e) {
            logger.error("Erro ao salvar aplicação quiz - " + e.getMessage());
        }finally {
             sessao.close();
        }

    }

    public void incluiPergunta(Pergunta pergunta) {
        logger.info("método - incluiPergunta()");

        try {
            if (null != pergunta.getId()) {
                perguntas.add(pergunta);
                modelperguntas = new ListDataModel<>(perguntas);
                logger.info("lista tem : " + perguntas.size());
            }

        } catch (HibernateException e) {
            logger.error("Erro ao incluiPergunta - " + e.getMessage());
        }
    }
    
    // Adiciona idQuiz escolhido para aplicacao no Explora Conteudo
    public void adicionaQuizEscolhido(Long idQuizSelecionado) {
		idQuiz = idQuizSelecionado;
    }

    /* * CRUD * */
    public String salvarQuiz() {
        logger.info("método - salvarQuiz()");

        try {
            sessao = HibernateUtil.abrirSessao();
            quiz.setUsuarioProprietario(LoginController.usuarioSessao());
//			quiz.setTitulo(fluxo);
            if (preparaQuiz()) {
                quizDao.salvarOuAlterar(quiz, sessao);
                idQuiz = quiz.getId();
//				idQuiz = new AplicacaoQuizDaoImpl().salvarRetornaId(quiz, sessao);
//				logger.error("Id retornado - " + idQuiz);
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
        if (null == quiz.getPerguntas() || quiz.getPerguntas().size() == 0) {
            Mensagem.erro("Sem perguntas para adicionar ao Quiz!");
            logger.error("Erro ao preparaQuiz - lista de perguntas vazia");

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
        if (quiz.getPerguntas().size() < 1) {
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
            List<Quiz> quizBd = quizDao.pesquisarPorIdQuiz(sessao,idQuiz);
            quiz = quizBd.get(0);
        } catch (HibernateException e) {
            logger.error("Erro ao pesquisar quiz elaborado pelo usuario: " + e.getMessage());
        } finally {
            sessao.close();
        }
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

}
