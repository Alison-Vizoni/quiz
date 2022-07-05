package br.com.quiz.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.UsuarioDao;
import br.com.quiz.model.dao.UsuarioDaoImpl;
import br.com.quiz.model.entidade.Usuario;
import javax.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "loginC")
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Logger logger = LoggerFactory.logger(getClass());

    private static Usuario usuarioLogado;
    private UsuarioDao usuarioDao;
    private Usuario usuario;
    private Session sessao;

    public LoginController() {
        usuarioDao = new UsuarioDaoImpl();
    }

    public String logar() {
        logger.info("método logar");
        try {
            if (usuario.getLogin() == "" || usuario.getSenha() == "") {
                Mensagem.erro("usuário e senha são obrigatórios!");
                return null;
            };

            pesquisaUsuarioPorLogin(usuario.getLogin());
            if(usuarioLogado != null) {
	            if (true == usuarioLogado.getStatusAtivo() && usuario.getLogin().equals(usuarioLogado.getLogin())
	                    && Criptografia.criptografar(usuario.getSenha()).equals(usuarioLogado.getSenha())) {
	                return "/inicio.xhtml?faces-redirect=true";
	
	            } else {
	                String mensagem = usuarioLogado.getStatusAtivo() ? "Usuário e/ou Senha incorretos(s)" : "Usuário desativado!";
	                Mensagem.erro(mensagem);
	                usuarioLogado = null;
	                return null;
	            }
            } else {
            	Mensagem.erro("Usuário e/ou Senha incorretos(s)");
            	usuarioLogado = null;
                return null;
            }
        } catch (Exception e) {
            logger.info("Erro na autenticação de usuário - " + e.getMessage());
            return null;
        }
    }

    public String logout() {
        logger.info("método logout");

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = null;
        usuarioLogado = null;
        return "/inicio?faces-redirect=true";
    }
    

    public void pesquisaUsuarioPorLogin(String login) {
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

    // GETTER AND SETTER
    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            usuarioLogado = new Usuario();
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLog) {
        usuarioLogado = usuarioLog;
    }

    public static Usuario usuarioSessao() {
        return usuarioLogado;
    }

}
