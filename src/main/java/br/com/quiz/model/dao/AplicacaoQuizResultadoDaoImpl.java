/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class AplicacaoQuizResultadoDaoImpl extends BaseDaoImpl<AplicacaoQuizResultado, Long> 
        implements AplicacaoQuizResultadoDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public AplicacaoQuizResultado pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (AplicacaoQuizResultado) sessao.get(AplicacaoQuizResultado.class, id);
    }
    
}
