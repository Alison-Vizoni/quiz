package br.com.quiz.model.bo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.controle.LoginController;
import br.com.quiz.model.dao.AplicacaoQuizDao;
import br.com.quiz.model.dao.AplicacaoQuizDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.entidade.AplicacaoQuiz;

public class AplicacaoQuizBO {
	
	private Logger logger = LoggerFactory.logger(getClass());
	
	private AplicacaoQuizDao aplicacaoQuizDao;
	private Session sessao;
	
	public AplicacaoQuizBO() {
		aplicacaoQuizDao = new AplicacaoQuizDaoImpl();
	}
	
	public boolean validaAcessoQuiz(Long idAplicacaoQuiz){
		logger.info("Método - validaAcessoQuiz BO");
		boolean acesso = false;
		if (this.verificarPermissaoParaResponderAplicacaoQuiz(idAplicacaoQuiz)) {
			if (!this.usuarioJaRespondeuQuiz(idAplicacaoQuiz)) {
				acesso = true;
			}
		}
		return acesso;
	}

	private boolean usuarioJaRespondeuQuiz(Long idAplicacaoQuiz) {
		try {
			sessao = HibernateUtil.abrirSessao();
			return aplicacaoQuizDao.usuarioJaRespondeuQuiz(
					idAplicacaoQuiz, LoginController.usuarioSessao().getId(), sessao);
		} catch (HibernateException e) {
			// TODO: handle exception
		} finally {
			sessao.close();
		}
		return false;
	}

	private boolean verificarPermissaoParaResponderAplicacaoQuiz(Long idAplicacaoQuiz) {
		try {
			sessao = HibernateUtil.abrirSessao();
			return aplicacaoQuizDao.verificarPermissaoParaResponderAplicacaoQuiz(
					idAplicacaoQuiz, LoginController.usuarioSessao().getEmail(), sessao);
		} catch (HibernateException e) {
			// TODO: handle exception
		} finally {
			sessao.close();
		}
		return false;
	}

}
