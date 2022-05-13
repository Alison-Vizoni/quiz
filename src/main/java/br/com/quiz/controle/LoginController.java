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

import br.com.quiz.model.entidade.Usuario;


/**
 *
 * @author alf_a
 */
//@ManagedBean(name = "loginC")
//@SessionScoped
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	
	public LoginController(){
		usuario = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		if(context instanceof SecurityContext)
		{
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication)
			{
				 usuario.setLogin(((User)authentication.getPrincipal()).getUsername());
			}
		}
		
	}

	public Usuario getUsuario() {
//		if (usuario == null) {
//			usuario = new Usuario();
//		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
