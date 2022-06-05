/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class AplicacaoQuizResultadoDaoImpl extends BaseDaoImpl<AplicacaoQuizResultado, Long> 
        implements AplicacaoQuizResultadoDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public AplicacaoQuizResultado pesquisarPorId(Long id, Session sessao) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AplicacaoQuizResultado> pesquisarPorIdAplicacaoQuiz(Long idAplicacaoQuiz, Session sessao) {
		Query consulta = sessao.createQuery("SELECT app FROM AplicacaoQuizResultado app WHERE app.id.idAplicacaoQuiz = :idAplicacaoQuiz");
        consulta.setParameter("idAplicacaoQuiz", idAplicacaoQuiz);
        return consulta.list();
	}

	@Override
	public List<AplicacaoQuizResultado> pesquisarPorId(Long idAplicacaoQuiz, Long idUsuario, Session sessao) {
		Query consulta = sessao.createQuery("SELECT app FROM AplicacaoQuizResultado app WHERE "
				+ " app.id.idAplicacaoQuiz = :idAplicacaoQuiz AND "
				+ " app.id.idUsuario = :idUsuario");
        consulta.setParameter("idAplicacaoQuiz", idAplicacaoQuiz);
        consulta.setParameter("idUsuario", idUsuario);
        return consulta.list();
	}

	@Override
	public AplicacaoQuizResultado pesquisarPorId(Long idAplicacaoQuiz, Long idUsuario, Long idAlternativa, Session sessao) {
		Query consulta = sessao.createQuery("SELECT app FROM AplicacaoQuizResultado app WHERE "
				+ " app.id.idAplicacaoQuiz = :idAplicacaoQuiz AND "
				+ " app.id.idUsuario = :idUsuario AND "
				+ " app.id.idAlternativa = :idAlternativa");
        consulta.setParameter("idAplicacaoQuiz", idAplicacaoQuiz);
        consulta.setParameter("idUsuario", idUsuario);
        consulta.setParameter("idAlternativa", idAlternativa);
        return (AplicacaoQuizResultado) consulta.uniqueResult();
	}
}
