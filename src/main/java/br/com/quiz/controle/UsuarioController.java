/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.quiz.model.bo.UsuarioBO;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.UsuarioDao;
import br.com.quiz.model.dao.UsuarioDaoImpl;
import br.com.quiz.model.entidade.Usuario;

/**
 *
 * @author ahgora
 */
@ManagedBean(name = "usuarioC")
@ViewScoped
public class UsuarioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
//    private Login login;
    private UsuarioBO usuarioBO;
//    private LoginDao loginDao;
    private UsuarioDao usuarioDao;
    private Session sessao;

    public UsuarioController() {
        usuarioDao = new UsuarioDaoImpl();
 //       loginDao = new LoginDaoImpl();
    }
     

    public void salvar() {
        sessao = HibernateUtil.abrirSessao();
        usuarioBO = new UsuarioBO();
        try {
            if (usuarioBO.existeEmail(usuario.getEmail(), sessao)) {
                Mensagem.erro("Email já cadastrado");
            } else {
//                login.setUsuario(usuario);
//                login.setLogin(usuario.getEmail());
//                usuarioDao.salvarOuAlterar(usuario, sessao);
//                loginDao.salvarOuAlterar(login, sessao);
//                Mensagem.sucesso("Salvo com sucesso");
            }

        } catch (HibernateException e) {
            System.err.println("Erro ao salvar " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    public Usuario getUsuario() {
        usuario = usuario == null ? new Usuario() : usuario;
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

//    public Login getLogin() {
//        login = login == null ? new Login() : login;
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }

}
