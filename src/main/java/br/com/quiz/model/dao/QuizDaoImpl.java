/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Quiz;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class QuizDaoImpl extends BaseDaoImpl<Quiz, Long> 
        implements QuizDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Quiz pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (Quiz) sessao.get(Quiz.class, id);
    }
    
}
