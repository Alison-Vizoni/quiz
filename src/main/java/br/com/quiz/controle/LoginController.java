package br.com.quiz.controle;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.quiz.model.entidade.Login;
import br.com.quiz.model.entidade.Usuario;

/**
*
* @author alf_a
*/
@ManagedBean(name = "loginC")
@SessionScoped
public class LoginController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Login login;
	FacesContext context;
	HttpServletRequest request;
	HttpServletResponse response;


	public LoginController() throws ServletException, IOException {
		context = FacesContext.getCurrentInstance();
		request =  (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	

	}

	public void iniciaSessao() throws ServletException, IOException {
		System.out.println("Entrou no inicia sessão");
		
//		login =  (Login) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (!response.isCommitted()){
			RequestDispatcher dispatcher = request.getRequestDispatcher("j_spring_security_check");
			   dispatcher.forward(this.request, this.response); 
			}
		
		context.responseComplete();	
	}
	

	public void encerraSessao() {
		System.out.println("Entrou no encerra sessão");
		
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		System.out.println("encerra - " + login.toString());
		
	}
	
	/* GETTERS AND SETTERS */
	
	public Login getLogin() {
		if (login == null) {
			login = new Login();
			
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
