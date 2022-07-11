package br.com.quiz.controle;

import br.com.quiz.model.bo.AplicacaoQuizBO;
import br.com.quiz.model.dao.AplicacaoQuizDaoImpl;
import br.com.quiz.model.dao.AplicacaoQuizResultadoDao;
import br.com.quiz.model.dao.AplicacaoQuizResultadoDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dto.AplicacaoQuizDTO;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import java.io.IOException;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "responderQuizC")
@SessionScoped
public class responderQuizController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Logger logger = LoggerFactory.logger(getClass());
    private AplicacaoQuizDaoImpl aplicacaoQuizDao;
    private AplicacaoQuizResultado aplicacaoQuizResultado;
    private AplicacaoQuizResultadoDao aplicacaoQuizResultadoDao;
    private AplicacaoQuiz aplicacaoQuiz;
    private List<Pergunta> perguntas = new ArrayList<>();
    private List<Alternativa> alternativas = new ArrayList<>();
    private List<AplicacaoQuizResultado> resultados;
    private List<AplicacaoQuizDTO> quizzesAplicadosDTO = new ArrayList<>();
    private Session sessao;
    private Pergunta pergunta;
    private Quiz quiz;
    private boolean quizFinalizou;
    public static Long idQuiz;

    public responderQuizController() {
        aplicacaoQuizDao = new AplicacaoQuizDaoImpl();
    }

    public String validaAcessoQuiz() throws IOException {
        logger.info("entrou no validaAcessoQuiz()");
        AplicacaoQuizBO aplicacaoQuizBO = new AplicacaoQuizBO();
        String mensagem = (String) aplicacaoQuizBO.validaAcessoQuiz(aplicacaoQuiz.getId());
        if ("ok".equals(mensagem)) {
            try {
                sessao = HibernateUtil.abrirSessao();
                aplicacaoQuiz = aplicacaoQuizDao.pesquisarPorId(aplicacaoQuiz.getId(), sessao);
                return "listaPerguntasQuiz.xhtml?faces-redirect=true";
            } catch (HibernateException e) {
                logger.error(e.getMessage());
            } finally {
                sessao.close();
            }
        } else {
            Mensagem.erro(mensagem);
        }
        return "";
    }

    public void pesquisaQuiz() {
        logger.info("entrou no pesquisaQuiz()");
        sessao = HibernateUtil.abrirSessao();
        try {
            verificaPerguntasFinalizadas();
            quizFinalizou = verificaPerguntaFinalizado();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            sessao.close();
        }

    }

    public void verificaPerguntasFinalizadas() {
        logger.info("entrou no verificaPerguntasFinalizadas()");
        perguntas = aplicacaoQuiz.getQuiz().getPerguntas();
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
        resultados = aplicacaoQuizResultadoDao.pesquisarPorId(aplicacaoQuiz.getId(), LoginController.usuarioSessao().getId(), sessao);

        for (AplicacaoQuizResultado resultado : resultados) {
            for (int i = 0; i < perguntas.size(); i++) {
                if (perguntas.get(i).getId() == resultado.getAlternativa().getPergunta().getId()) {
                    perguntas.get(i).setStatusAtivo(false);
                }
            }
        }
    }

    public boolean validaPerguntaResponder(int idPergunta) {

        if (resultados == null) {
            return false;
        }
        for (AplicacaoQuizResultado resultado : resultados) {
            if (idPergunta == resultado.getAlternativa().getPergunta().getId()) {
                return true;
            }
        }
        return false;
    }

    public void validaPerguntaResponderRedirect(int idPergunta) throws IOException {
        if (validaPerguntaResponder(idPergunta)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listaPerguntasQuiz.xhtml");
        }
    }

    ;

    public String finalizarQuiz() {
        logger.info("entrou no finalizarQuiz()");
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
        removerPerguntasJaSalvadas();

        for (int i = 0; i < perguntas.size(); i++) {
            try {
                aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
                aplicacaoQuizResultado = new AplicacaoQuizResultado(Date.from(Instant.now()));
                aplicacaoQuizResultado.setUsuario(LoginController.usuarioSessao());
                aplicacaoQuizResultado.setAplicacaoQuiz(aplicacaoQuiz);
                aplicacaoQuizResultado.setAlternativa(salvaAlternativaErrada(perguntas.get(i).getAlternativas()));
                sessao = HibernateUtil.abrirSessao();
                aplicacaoQuizResultadoDao.salvarOuAlterar(aplicacaoQuizResultado, sessao);

            } catch (Exception e) {
                logger.error(e.getMessage());
            } finally {

            }

        }

        return "resultadoQuiz.html?faces-redirect=true";
    }

    public void removerPerguntasJaSalvadas() {

        for (int i = 0; i < perguntas.size(); i++) {
            for (AplicacaoQuizResultado resultado : resultados) {
                if (perguntas.get(i).getId() == resultado.getAlternativa().getPergunta().getId()) {
                    perguntas.remove(i);
                }
            }
        }
    }

    public Alternativa salvaAlternativaErrada(List<Alternativa> alternativas) {

        Alternativa alternativaErrada = new Alternativa();
        for (int i = 0; i < alternativas.size(); i++) {
            if (!alternativas.get(i).isStatusCorreta()) {
                alternativaErrada = alternativas.get(i);
                break;
            }
        }
        return alternativaErrada;
    }

    public boolean verificaPerguntaFinalizado() {
        logger.info("entrou no verificaPerguntaFinalizado()");

        perguntas = aplicacaoQuiz.getQuiz().getPerguntas();
        boolean foiFinalizado = true;
        for (int i = 0; i < perguntas.size(); i++) {
            if (perguntas.get(i).getStatusAtivo()) {
                foiFinalizado = false;
                break;
            }
        }
        return foiFinalizado;
    }

    public String responderPergunta(int idPergunta) {
        logger.info("entrou no responderPergunta()");

        if (validaPerguntaResponder(idPergunta)) {
            Mensagem.erro("Está pergunta já foi respondida");
            return "";
        } else {
            for (int i = 0; i < perguntas.size(); i++) {
                if (perguntas.get(i).getId() == idPergunta) {
                    pergunta = perguntas.get(i);
                    break;
                }
            }
            return "responderQuiz.xhtml";
        }
    }

    public String enviarResposta(Alternativa alternativa) {
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
        aplicacaoQuizResultado = new AplicacaoQuizResultado(Date.from(Instant.now()));
        aplicacaoQuizResultado.setUsuario(LoginController.usuarioSessao());
        aplicacaoQuizResultado.setAplicacaoQuiz(aplicacaoQuiz);
        aplicacaoQuizResultado.setAlternativa(alternativa);

        sessao = HibernateUtil.abrirSessao();
        aplicacaoQuizResultadoDao.salvarOuAlterar(aplicacaoQuizResultado, sessao);
        sessao.close();
        return "listaPerguntasQuiz.xhtml";
    }

    public String random_rgba(int index) {

        if (index % 4 == 0) {
            return "#d03dba";
        }

        if (index % 3 == 0) {
            return "#ba87e9";
        }

        if (index % 2 == 0) {
            return "#6446d7";
        }

        return "#e98787";
    }

    public String resultadoFinal(Long idQuiz) {
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
        sessao = HibernateUtil.abrirSessao();
        List<AplicacaoQuizResultado> aplicacaoQuizResultado = null;
        try {
            aplicacaoQuizResultado = aplicacaoQuizResultadoDao
                    .pesquisarPorId(idQuiz == null ? aplicacaoQuiz.getId() : idQuiz, LoginController.usuarioSessao().getId(), sessao);
        } catch (Exception e) {
        } finally {
            sessao.close();
        }

        aplicacaoQuiz = null;
        return formataRespostaFinal(aplicacaoQuizResultado);
    }

    public String resultadoFinalUsuario(Long idAplicacao, Long idUsuario) {
        aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
        sessao = HibernateUtil.abrirSessao();
        List<AplicacaoQuizResultado> aplicacaoQuizResultado = null;
        try {
            aplicacaoQuizResultado = aplicacaoQuizResultadoDao
                    .pesquisarPorId(idAplicacao, idUsuario, sessao);
        } catch (Exception e) {
        } finally {
            sessao.close();
        }

        aplicacaoQuiz = null;
        return formataRespostaFinal(aplicacaoQuizResultado);
    }

    public String formataRespostaFinal(List<AplicacaoQuizResultado> aplicacaoQuizResultado) {
        int totalRespostasCorretas = 0;
        for (int i = 0; i < aplicacaoQuizResultado.size(); i++) {
            totalRespostasCorretas += aplicacaoQuizResultado.get(i).getAlternativa().isStatusCorreta() ? 1 : 0;
        }

        return totalRespostasCorretas + "/" + aplicacaoQuizResultado.size();
    }

    public void buscarQuizzesAplicados() {
        logger.info("Método Buscar quizzes aplicados.");

        Long id_usuario_logado = LoginController.usuarioSessao().getId();
        sessao = HibernateUtil.abrirSessao();
        try {
            if (quizzesAplicadosDTO.size() == 0) {

                List<AplicacaoQuiz> quizzesAplicados = aplicacaoQuizDao.buscarQuizzesAplicados(id_usuario_logado, sessao);
                this.converterParaDTO(quizzesAplicados);
            }
        } catch (HibernateException e) {
            logger.error("Erro ao buscar quizzes aplicados" + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    private void converterParaDTO(List<AplicacaoQuiz> quizzesAplicados) {
        for (AplicacaoQuiz quizAplicado : quizzesAplicados) {
            AplicacaoQuizDTO quizAplicadoDTO = new AplicacaoQuizDTO();
            quizAplicadoDTO.setIdAplicacaoQuiz(quizAplicado.getId());
            quizAplicadoDTO.setDataAplicacao(quizAplicado.getDataAplicacao());
            quizAplicadoDTO.setTituloQuiz(quizAplicado.getQuiz().getTitulo());
            quizAplicadoDTO.setQuantidadeTotalDePessoas(quizAplicado.getEmails().size());
            quizAplicadoDTO.setQuantidadeDePessoasQueResponderam(quizAplicado.getQuizResultado().size());
            quizzesAplicadosDTO.add(quizAplicadoDTO);
        }
    }

    public static void main(String[] args) {
        AplicacaoQuizController test = new AplicacaoQuizController();
        test.buscarQuizzesAplicados();
    }

    public void voltaListaPerguntas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("listaPerguntasQuiz.xhtml");
    }

    public AplicacaoQuizDaoImpl getAplicacaoQuizDao() {
        return aplicacaoQuizDao;
    }

    public void setAplicacaoQuizDao(AplicacaoQuizDaoImpl AplicacaoQuizDao) {
        this.aplicacaoQuizDao = AplicacaoQuizDao;
    }

    public AplicacaoQuiz getAplicacaoQuiz() {
        if (aplicacaoQuiz == null) {
            aplicacaoQuiz = new AplicacaoQuiz();
        }
        return aplicacaoQuiz;
    }

    public void setAplicacaoQuiz(AplicacaoQuiz aplicacaoQuiz) {
        this.aplicacaoQuiz = aplicacaoQuiz;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> Perguntas) {
        this.perguntas = Perguntas;
    }

    public boolean isQuizFinalizou() {
        return quizFinalizou;
    }

    public void setQuizFinalizou(boolean quizFinalizou) {
        this.quizFinalizou = quizFinalizou;
    }

    public List<AplicacaoQuizDTO> getQuizzesAplicadosDTO() {
        return quizzesAplicadosDTO;
    }

    public void setQuizzesAplicadosDTO(List<AplicacaoQuizDTO> quizzesAplicadosDTO) {
        this.quizzesAplicadosDTO = quizzesAplicadosDTO;
    }

}
