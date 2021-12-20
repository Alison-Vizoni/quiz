/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Alternativa;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class AlternativaDaoImpl extends BaseDaoImpl<Alternativa, Long> 
        implements AlternativaDao, Serializable{

    @Override
    public Alternativa pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (Alternativa) sessao.get(Alternativa.class, id);
    }
    
}
