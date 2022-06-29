/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.bo;

import br.com.quiz.model.dao.UsuarioDao;
import br.com.quiz.model.dao.UsuarioDaoImpl;
import br.com.quiz.model.entidade.Usuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ahgora
 */
public class UsuarioBO {

    private UsuarioDao usuarioDao;

    public UsuarioBO() {
        usuarioDao = new UsuarioDaoImpl();
    }

    public boolean existeEmail(String email, Session sessao) {
        List<Usuario> usuarios = usuarioDao.pesquisarPorEmail(email, sessao);
        return usuarios.size() > 0;
    }

    public String validaUsuario(Usuario usuario, String confirmaSenha) {
        String novaSenha = usuario.getSenha();
        String confirmarSenha = confirmaSenha;
        if (usuario.getEmail() == "" || confirmaSenha == "" || usuario.getCpf() == "" || usuario.getNome() == "" || usuario.getTelefone() == "" || usuario.getSenha() == "") {
            return "Todos os campos devem ser preenchidos";
        }
        if (novaSenha == confirmarSenha) {
            return "Senhas diferentes!";
        }
        return "ok";
    }

}
