package br.com.quiz.controle;

import br.com.quiz.model.dao.AplicacaoQuizDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "aplicacaoQuizC")
@SessionScoped
public class AplicacaoQuizController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Logger logger = LoggerFactory.logger(getClass());
    private AplicacaoQuizDaoImpl AplicacaoQuizDao;
    private AplicacaoQuiz aplicacaoQuiz;
    private List<Quiz> quizzes = new ArrayList<>();
    private Session sessao;
    private Pergunta pergunta;
    private Quiz quiz;
    public static Long idQuiz;

    public AplicacaoQuizController() {
        if (aplicacaoQuiz == null) {
            aplicacaoQuiz = new AplicacaoQuiz();
        }

        AplicacaoQuizDao = new AplicacaoQuizDaoImpl();
    }

    public String validaAcessoQuiz() {
        logger.info("entrou no validaAcessoQuiz()");
        sessao = HibernateUtil.abrirSessao();

        aplicacaoQuiz = AplicacaoQuizDao.pesquisarPorID(aplicacaoQuiz.getId(), sessao);
        if (aplicacaoQuiz.getEmails().contains(LoginController.usuarioSessao().getEmail())) {

            return "listaPerguntasQuiz.xhtml";
        }
        return "";
    }

    public void pesquisaQuiz() {
        logger.info("entrou no pesquisaQuiz()");
        sessao = HibernateUtil.abrirSessao();

        aplicacaoQuiz = AplicacaoQuizDao.pesquisarPorID(aplicacaoQuiz.getId(), sessao);
    }

    public void responderPergunta(int idPergunta) {
        logger.info("entrou no responderPergunta()");
        List<Pergunta> perguntas = aplicacaoQuiz.getQuiz().getPerguntas();

        for (int i = 0; i < perguntas.size(); i++) {
            if (perguntas.get(i).getId() == idPergunta) {
                pergunta = perguntas.get(i);
                break;
            }
        }
        System.out.println(pergunta);
    }

    public String random_rgba(int index) {
        
        if(index % 2 != 0){
            return "#d03dba";        
        }
        
        if(index % 3 != 0){
            return "#ba87e9";
        }
         return "#e98787";
    }

//	
    public AplicacaoQuizDaoImpl getAplicacaoQuizDao() {
        return AplicacaoQuizDao;
    }

    public void setAplicacaoQuizDao(AplicacaoQuizDaoImpl AplicacaoQuizDao) {
        this.AplicacaoQuizDao = AplicacaoQuizDao;
    }

    public AplicacaoQuiz getAplicacaoQuiz() {
        return aplicacaoQuiz;
    }

    public void setAplicacaoQuiz(AplicacaoQuiz aplicacaoQuiz) {
        this.aplicacaoQuiz = aplicacaoQuiz;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

}
