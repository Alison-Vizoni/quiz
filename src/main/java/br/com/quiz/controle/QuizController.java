package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.QuizDao;
import br.com.quiz.model.dao.QuizDaoImpl;
import br.com.quiz.model.entidade.Alternativa;
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
	private DataModel<Pergunta> modelperguntas;
	private Pergunta pergunta;
	private Pergunta perguntaSelecionada;

	private Session sessao;
	private String fluxo;

	public QuizController() {
		if (quiz == null) {
			quiz = new Quiz();
		}		
		quizDao = new QuizDaoImpl();
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
//		logger.info("modelperguntas tem : " + modelperguntas.getRowCount());
		
	}
	

	/* * CRUD * */

	public void incluiPergunta(Pergunta pergunta) {
		logger.info("método - incluiPergunta()");

		try {
			if (null != pergunta.getId()) {
				perguntas.add(pergunta);
				modelperguntas = new ListDataModel<>(perguntas);
				logger.info("lista tem : " + perguntas.size());
//				logger.info("modelperguntas tem : " + modelperguntas.getRowCount());			
			}

		} catch (HibernateException e) {
			logger.error("Erro ao incluiPergunta - " + e.getMessage());
		}
	}
	
	public void salvarQuiz() {
		logger.info("método - salvarQuiz()");

		try {
			sessao = HibernateUtil.abrirSessao();
			if (preparaQuiz()) {
				quizDao.salvarOuAlterar(quiz, sessao);				
			}
			defineFluxo();

		} catch (HibernateException e) {
			logger.error("Erro ao salvar - " + e.getMessage());
		} finally {
			sessao.close();
		}
	}
	
	private boolean preparaQuiz() {
		logger.info("método - preparaQuiz()");
		
		boolean quizValido = false;		
		quiz.setPerguntas(perguntas);
		if (null ==  quiz.getPerguntas() || quiz.getPerguntas().size() == 0) {
			Mensagem.erro("Sem perguntas para adicionar ao Quiz!");
			logger.error("Erro ao preparaQuiz - lista de perguntas vazia");
			
		} else {
			Date criacao = new Date(System.currentTimeMillis());
			quiz.setDataCriacao(criacao);
			quiz.setCategoria(perguntas.get(0).getCategoria().getNome());
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

}
