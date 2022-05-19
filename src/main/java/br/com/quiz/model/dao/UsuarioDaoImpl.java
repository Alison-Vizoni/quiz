/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> 
        implements UsuarioDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Usuario pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (Usuario) sessao.get(Usuario.class, id);
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome, Session sessao) 
            throws HibernateException {
        Query consulta = sessao.createQuery("FROM Usuario WHERE nome = :nome");
        consulta.setParameter("nome", nome);
        return consulta.list();
    }
    
    @Override
    public List<Usuario> pesquisarPorEmail(String email, Session sessao) 
            throws HibernateException {
        Query consulta = sessao.createQuery("FROM Usuario WHERE email = :email");
        consulta.setParameter("email", email);
        return consulta.list();
    }
    
    @Override
	public Usuario buscaPorLogin(String login, Session sessao) {
		Query consulta = sessao.createQuery("FROM Usuario WHERE login = :login");
		consulta.setParameter("login", login);
		consulta.setMaxResults(1);
		return (Usuario) consulta.uniqueResult();
	}
    
}
