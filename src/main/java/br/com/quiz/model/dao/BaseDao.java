/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.model.dao;

import org.hibernate.*;

/**
 *
 * @author alison.vizoni
 * @param <T>
 * @param <ID>
 */
public interface BaseDao<T, ID> {
    
    void salvarOuAlterar(T entidade, Session sessao) throws HibernateException;
    
    void excluir(T entidade, Session sessao)throws HibernateException;
    
    T pesquisarPorID(Long id, Session sessao )throws HibernateException;
}
