package br.com.quiz.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.UsuarioDao;
import br.com.quiz.model.dao.UsuarioDaoImpl;
import br.com.quiz.model.entidade.Usuario;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "usuarioLogadoC")
@SessionScoped
public class UsuarioLogado {

	private final Logger logger = LoggerFactory.logger(getClass());

	private static Usuario usuarioLogado;
	private UsuarioDao usuarioDao;
    private Session sessao;

	public UsuarioLogado() {
//		login();
	}

//	public void login() {
//		usuarioDao = new UsuarioDaoImpl();
//        SecurityContext context = SecurityContextHolder.getContext();
//        if(context instanceof SecurityContext){
//            Authentication authentication = context.getAuthentication();
//            if(authentication instanceof Authentication){
//            	try {
//            		String login = ((User)authentication.getPrincipal()).getUsername();
//            	// 	String login = "asd";
//            		pesquisaUsuarioPorLogin(login);
//            		
//            	} catch(Exception e) {
//            		logger.error(e.getMessage());
//            	}
//            }
//        }
//	}
	
	public void login(String login) {
		usuarioDao = new UsuarioDaoImpl();
        SecurityContext context = SecurityContextHolder.getContext();
        if(context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if(authentication instanceof Authentication){
            	try {
            	//	String login = ((User)authentication.getPrincipal()).getUsername();
            	// 	String login = "asd";
            		pesquisaUsuarioPorLogin(login);
            		
            	} catch(Exception e) {
            		logger.error(e.getMessage());
            	}
           }
        }
	}

	private void pesquisaUsuarioPorLogin(String login) {
		logger.info("método pesquisaPorLogin");

		try {
			sessao = HibernateUtil.abrirSessao();
			usuarioLogado = usuarioDao.buscaPorLogin(login, sessao);
		} catch (Exception e) {
			logger.error("Erro na busca de usuário por login - " + e.getMessage());
		} finally {
			sessao.close();
		}

	}


	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
        return usuarioLogado;
    }
    
    public static Usuario usuarioLogado(){
        return usuarioLogado;
    }

}
