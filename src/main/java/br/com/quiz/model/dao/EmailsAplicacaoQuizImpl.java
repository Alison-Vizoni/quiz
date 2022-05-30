/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Alternativa;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

/**
 *
 * @author alison
 */
public class EmailsAplicacaoQuizImpl extends BaseDaoImpl<String, Long>
        implements EmailsAplicacaoQuizDao, Serializable {

    private static final long serialVersionUID = 1L;

    private final Logger logger = LoggerFactory.logger(getClass());

    @Override
    public String pesquisarPorEmail(String Email, Session sessao) {
        Query consulta = sessao.createQuery("FROM emails_aplicacao_quiz  WHERE emails = :email");
        consulta.setParameter("email", Email);
        return (String) consulta.uniqueResult();
    }

    @Override
    public String pesquisarPorID(Long id, Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
