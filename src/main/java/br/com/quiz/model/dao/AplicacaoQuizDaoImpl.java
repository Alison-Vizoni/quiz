/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.quiz.model.entidade.AplicacaoQuiz;

/**
 *
 * @author alison
 */
public class AplicacaoQuizDaoImpl extends BaseDaoImpl<AplicacaoQuiz, Long>
        implements AplicacaoQuizDao, Serializable {

    private static final long serialVersionUID = 1L;

	@Override
    public AplicacaoQuiz pesquisarPorId(Long id, Session sessao) 
            throws HibernateException {
        return (AplicacaoQuiz) sessao.get(AplicacaoQuiz.class, id);
    }

	@Override
	public boolean verificarPermissaoParaResponderAplicacaoQuiz(Long idAplicacaoQuiz, String email, Session sessao) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT ap FROM AplicacaoQuiz ap JOIN ap.emails em ");
		sql.append(" WHERE ap.id = :idAplicacaoQuiz ");
		sql.append(" AND em = :email ");
		
		Query consulta = sessao.createQuery(sql.toString());
		
		consulta.setParameter("idAplicacaoQuiz", idAplicacaoQuiz);
		consulta.setParameter("email", email);
		
		if (consulta.list().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean usuarioJaRespondeuQuiz(Long idAplicacaoQuiz, Long idUsuario, Session sessao) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT ap FROM AplicacaoQuizResultado ap ");
		sql.append(" WHERE ap.id.idAplicacaoQuiz = :idAplicacaoQuiz ");
		sql.append(" AND ap.id.idUsuario = :idUsuario ");
		
		Query consulta = sessao.createQuery(sql.toString());
		
		consulta.setParameter("idAplicacaoQuiz", idAplicacaoQuiz);
		consulta.setParameter("idUsuario", idUsuario);
		
		if (consulta.list().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public List<AplicacaoQuiz> buscarQuizzesAplicados(Long id_usuario_logado, Session sessao) {
		StringBuilder sql = new StringBuilder();
		sql.append("FROM AplicacaoQuiz WHERE usuarioAplicador.id = :id_usuario_logado ");
		
		Query consulta = sessao.createQuery(sql.toString());
		
		consulta.setParameter("id_usuario_logado", id_usuario_logado);
		
		return consulta.list();
	}
}
