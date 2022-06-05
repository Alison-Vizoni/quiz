/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Pergunta;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

/**
 *
 * @author alison
 */
public class AlternativaDaoImpl extends BaseDaoImpl<Alternativa, Long> 
        implements AlternativaDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.logger(getClass());

	@Override
    public Alternativa pesquisarPorId(Long id, Session sessao) 
            throws HibernateException {
        return (Alternativa) sessao.get(Alternativa.class, id);
    }

	@Override
	public List<Alternativa> pesquisarPorPergunta(Pergunta pergunta, Session sessao) {
		logger.info("método pesquisarPorPergunta()");
		Query consulta = sessao.createQuery("FROM Alternativa WHERE pergunta = :pergunta");
		consulta.setParameter("pergunta", pergunta);
		return consulta.list();
	}
    
}
