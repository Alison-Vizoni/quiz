/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class AplicacaoQuizDaoImpl extends BaseDaoImpl<AplicacaoQuiz, Long> 
        implements AplicacaoQuizDao, Serializable{

    @Override
    public AplicacaoQuiz pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (AplicacaoQuiz) sessao.get(AplicacaoQuiz.class, id);
    }
    
}
