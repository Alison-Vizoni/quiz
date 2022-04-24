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
		usuarioDao = new UsuarioDaoImpl();
        SecurityContext context = SecurityContextHolder.getContext();
        if(context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if(authentication instanceof Authentication){
 //               String login = ((User)authentication.getPrincipal()).getUsername();
                String login = "asd";
                pesquisaUsuarioPorLogin(login);
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

	public void encerraSessao() {
		System.out.println("Entrou no encerra sessão");

//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		System.out.println("encerra - " + usuarioLogado.toString());

	}
//
	public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public static Usuario usuarioLogado(){
        return usuarioLogado;
    }

}
