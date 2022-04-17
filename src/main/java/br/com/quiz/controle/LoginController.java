package br.com.quiz.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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


	public LoginController() {
		login =  (Login) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal(); 

	}

		
	public void iniciaSessao() {
		System.out.println("Entrou no inicia sessão");
//		login = new Login();
//		login.setId(1L);
//		login.setLogin("log");
//		login.setSenha("sen");
//		login.setUsuario(new Usuario("João", "999.999.999-99", "joao@gmail.com", "(48) 99999-9999"));
//		System.out.println("iniciaSessao - " + login.toString());
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
