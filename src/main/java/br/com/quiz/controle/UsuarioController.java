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
    private UsuarioBO usuarioBO;
    private UsuarioDao usuarioDao;
    private Session sessao;
    private String confirmarSenha;

    public UsuarioController() {
        usuarioDao = new UsuarioDaoImpl();
    }

    public void salvar() {
        sessao = HibernateUtil.abrirSessao();
        usuarioBO = new UsuarioBO();
        try {
            if (usuarioBO.existeEmail(usuario.getEmail(), sessao)) {
                Mensagem.erro("Email já cadastrado");
            } else if (!this.validarSenha()){
            	Mensagem.erro("Senha incorreta");
            } else {
            	usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
            	// TODO criar campo de nome, cpf e telefone ao cadastrar
            	usuario.setCpf("14785236985");
            	usuario.setNome(usuario.getLogin());
                usuarioDao.salvarOuAlterar(usuario, sessao);
            }
        } catch (HibernateException e) {
            System.err.println("Erro ao salvar " + e.getMessage());
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
}
