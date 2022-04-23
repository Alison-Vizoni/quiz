package br.com.quiz.controle;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;

import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.LoginDao;
import br.com.quiz.model.dao.LoginDaoImpl;
import br.com.quiz.model.entidade.Login;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "loginC")
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.logger(getClass());

	private Session sessao;
	private LoginDao loginDao;
	private Login logado;

	public LoginController() throws ServletException, IOException {

		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				loginDao = new LoginDaoImpl();
				sessao =HibernateUtil.abrirSessao();
				try{
					String login = (String) authentication.getPrincipal();
					pesquisaPorLogin(login);					
					
				}catch(Exception e) {
					System.out.println("errado "+e.getMessage());
				}
			}
		}
	}

	private void pesquisaPorLogin(String login) {
		logger.info("método pesquisaPorLogin");
		logado = loginDao.buscaPorLogin(login, sessao);

		try {
			sessao = HibernateUtil.abrirSessao();
		} catch (Exception e) {
			logger.error(e);
		} finally{
			sessao.close();
		}
		
	}

	public void iniciaSessao() throws ServletException, IOException {
		System.out.println("Entrou no inicia sessão");

	}

	public void encerraSessao() {
		System.out.println("Entrou no encerra sessão");

//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		System.out.println("encerra - " + logado.toString());

	}

	/* GETTERS AND SETTERS */

	public Login getLogin() {
		if (logado == null) {
			logado = new Login();

		}
		return logado;
	}

	public void setLogin(Login login) {
		this.logado = login;
	}

}
