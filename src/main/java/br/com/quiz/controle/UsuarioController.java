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
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author ahgora
 */
@ManagedBean(name = "usuarioC")
@ViewScoped
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    public Usuario usuarioEdit;
    private UsuarioBO usuarioBO;
    private UsuarioDao usuarioDao;
    private Session sessao;
    private String confirmarSenha;

    public UsuarioController() {
        usuarioDao = new UsuarioDaoImpl();
    }

    public String salvar() throws IOException {
        sessao = HibernateUtil.abrirSessao();
        usuarioBO = new UsuarioBO();

        try {
            String mensagem = usuarioBO.validaUsuario(usuario, confirmarSenha);
            boolean emailExists = usuarioBO.existeEmail(usuario.getEmail(), sessao);
            if (mensagem != "ok" || emailExists) {
                mensagem = emailExists ? "Email já cadastrado" : mensagem;
                Mensagem.erro(mensagem);
                return null;
            } else {
                usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
                usuarioDao.salvarOuAlterar(usuario, sessao);
                LoginController login = new LoginController();
                login.pesquisaUsuarioPorLogin(usuario.getLogin());
                FacesContext.getCurrentInstance().getExternalContext().redirect("/quiz/inicio.xhtml");
            }
        } catch (HibernateException e) {
            System.err.println("Erro ao salvar " + e.getMessage());
        } finally {
            sessao.close();

        }
        return null;
    }

    public void usuarioSessao() {
        usuarioEdit = LoginController.usuarioSessao();
    }

    public void editar() {
        sessao = HibernateUtil.abrirSessao();
        try {
            usuarioDao.salvarOuAlterar(usuarioEdit, sessao);
        } catch (Exception e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        } finally {
            sessao.close();
        }
    }

    public void desativarConta() {
        sessao = HibernateUtil.abrirSessao();
        try {
            usuarioEdit.setStatusAtivo(false);
            usuarioDao.salvarOuAlterar(usuarioEdit, sessao);
            LoginController login = new LoginController();
            login.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/quiz/login.xhtml");

        } catch (Exception e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        } finally {
            sessao.close();
        }

    }

    private boolean validarSenha() {
        if (confirmarSenha != null && confirmarSenha.equals(usuario.getSenha())) {
            return true;
        }
        return false;
    }

    public Usuario getUsuario() {
        usuario = usuario == null ? new Usuario() : usuario;
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public void setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = usuarioEdit;
    }

}
