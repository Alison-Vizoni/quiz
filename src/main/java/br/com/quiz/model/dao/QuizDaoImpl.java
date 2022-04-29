/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Quiz;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.jboss.logging.Logger;

/**
 *
 * @author alison
 */
public class QuizDaoImpl extends BaseDaoImpl<Quiz, Long> 
        implements QuizDao, Serializable{
	private final Logger logger = LoggerFactory.logger(getClass());
	private static final long serialVersionUID = 1L;

    @Override
    public Quiz pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
        return (Quiz) sessao.get(Quiz.class, id);
    }

    public List<Quiz> buscarQuizPorUsuario(Session sessao, Long i) {
        logger.info("método buscarQuizPorUsuario()");
        Query consulta = sessao.createQuery("FROM Quiz WHERE id_usuario_proprietario = :id");
        consulta.setParameter("id", i);
        return consulta.list();

    }
   

}
