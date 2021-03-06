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
import br.com.quiz.model.entidade.SubCategoria;

/**
 *
 * @author alison
 */
public class SubCategoriaDaoImpl extends BaseDaoImpl<SubCategoria, Long> 
        implements SubCategoriaDao, Serializable{

    private static final long serialVersionUID = 1L;

	@Override
    public SubCategoria pesquisarPorId(Long id, Session sessao) 
            throws HibernateException {
        return (SubCategoria) sessao.get(SubCategoria.class, id);
    }

    @Override
    public List<SubCategoria> pesquisarPorNome(String nome, Session sessao) 
            throws HibernateException {
        Query consulta = sessao.createQuery("FROM SubCategoria WHERE nome = :nome");
        consulta.setParameter("nome", nome);
        return consulta.list();
    }
    
    @Override
    public List<SubCategoria> pesquisarPorIdCategoria(Long id_categoria, Session sessao) 
            throws HibernateException {
        Query consulta = sessao.createQuery("FROM SubCategoria WHERE id_categoria = :id_categoria");
        consulta.setParameter("id_categoria", id_categoria);
        return consulta.list();
    }

    @Override
    public List<SubCategoria> populaComboInicial(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("FROM SubCategoria");
        return consulta.list();
    }

    @Override
    public SubCategoria buscaNomeEspecifico(String nome, Session sessao) {
        Query query = sessao.createQuery("FROM SubCategoria WHERE nome = :nome");
        query.setMaxResults(1);
        return (SubCategoria) query.uniqueResult();
    }
    
    public List<SubCategoria> buscaPorCategoria(Categoria categoria, Session sessao) {
    	Query query = sessao.createQuery("FROM SubCategoria WHERE categoria = :categoria");
    	query.setParameter("categoria", categoria);
    	return (List<SubCategoria>) query.list();
    }
}
