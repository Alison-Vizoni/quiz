/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.quiz.model.entidade.Categoria;

/**
 *
 * @author alison
 */
public class CategoriaDaoImpl extends BaseDaoImpl<Categoria, Long> 
        implements CategoriaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Categoria pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (Categoria) sessao.get(Categoria.class, id);
    }

    @Override
    public List<Categoria> pesquisarPorNome(String nome, Session sessao) 
            throws HibernateException {
        Query consulta = sessao.createQuery("FROM Categoria WHERE nome = :nome");
        consulta.setParameter("nome", nome);
        return consulta.list();
    }

    @Override
    public List<Categoria> populaComboInicial(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("FROM Categoria");
        return consulta.list();
    }

    @Override
    public Categoria buscaNomeEspecifico(String nome, Session sessao) {
        Query query = sessao.createQuery("FROM Categoria WHERE nome = :nome");
        query.setMaxResults(1);
        Categoria cat = (Categoria) query.uniqueResult();
        return cat;
    }
    
}
