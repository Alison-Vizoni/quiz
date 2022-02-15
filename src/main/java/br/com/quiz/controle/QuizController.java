package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.QuizDao;
import br.com.quiz.model.dao.QuizDaoImpl;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;

/**
*
* @author alf_a
*/
@ManagedBean(name = "quizC")
@ViewScoped
public class QuizController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.logger(getClass());
	
	private QuizDao quizDao;
	private Quiz quiz;
	
	private List<Pergunta> perguntas = new ArrayList<>();
	 private Pergunta pergunta;

	private Session sessao;
	
	public QuizController() {
		if (quiz == null) {
			quiz = new Quiz();
		} 
		quizDao = new QuizDaoImpl();
	}
	
	/* *  CRUD  * */
	
	public void incluiPergunta(Pergunta pergunta) {
            logger.info("método - incluiPergunta()");
    	
            try {
                perguntas.add(pergunta);
                logger.info("lista tem : " + perguntas.size());

            } catch (HibernateException e) {
                    logger.error("Erro ao incluiPergunta - " + e.getMessage());
            }
	}
	
	public void preparaQuiz() {
		logger.info("método - preparaQuiz()");
    	
            try {
                sessao = HibernateUtil.abrirSessao();
                Date criacao =  new Date(System.currentTimeMillis());
                quiz.setDataCriacao(criacao);
                quiz.setCategoria(perguntas.get(0).getCategoria().getNome());
                quiz.setPerguntas(perguntas);

            } catch (HibernateException e) {
                    logger.error("Erro ao preparaQuiz - " + e.getMessage());
            } finally {
                sessao.close();
            }
	}

	public void salvarQuiz() {
            logger.info("método - salvarQuiz()");

            try {
                sessao = HibernateUtil.abrirSessao();
                quizDao.salvarOuAlterar(quiz, sessao);

            } catch (HibernateException e) {
                logger.error("Erro ao salvar - " + e.getMessage());
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
	
}
