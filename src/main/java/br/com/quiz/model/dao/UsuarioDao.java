/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    
    List<Usuario> pesquisarPorNome(String nome, Session sessao)
            throws HibernateException;
    
     List<Usuario> pesquisarPorEmail(String nome, Session sessao)
            throws HibernateException;
}
