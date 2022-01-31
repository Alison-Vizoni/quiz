/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Pergunta;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class PerguntaDaoImpl extends BaseDaoImpl<Pergunta, Long> 
        implements PerguntaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Pergunta pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (Pergunta) sessao.get(Pergunta.class, id);
    }
    
}
