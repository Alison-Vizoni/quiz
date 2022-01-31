/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Login;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ahgora
 */
public class LoginDaoImpl extends BaseDaoImpl<Login, Long> 
        implements LoginDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Login pesquisarPorID(Long id, Session sessao) throws HibernateException {
        return (Login) sessao.get(Login.class, id);
    }
    
    
}
