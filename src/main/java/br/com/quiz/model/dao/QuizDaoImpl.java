/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import br.com.quiz.model.entidade.Usuario;

/**
 *
 * @author alison
 */
public class QuizDaoImpl extends BaseDaoImpl<Quiz, Long> implements QuizDao, Serializable {
	private final Logger logger = LoggerFactory.logger(getClass());
	private static final long serialVersionUID = 1L;

	@Override
	public Quiz pesquisarPorId(Long id, Session sessao) throws HibernateException {
		return (Quiz) sessao.get(Quiz.class, id);
	}

	@Override
	public List<Quiz> pesquisarPorIdQuiz(Session sessao, Long idQuiz) throws HibernateException {
		Query consulta = sessao.createQuery("FROM Quiz WHERE id = :id");
		consulta.setParameter("id", idQuiz);
		return consulta.list();
	}

	public Quiz pesquisarPorID(Long id, Session sessao) throws HibernateException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

    public List<Quiz> buscarQuizPorUsuario(Session sessao, Long i) {
        logger.info("método buscarQuizPorUsuario()");
        Query consulta = sessao.createQuery("FROM Quiz WHERE id_usuario_proprietario = :id AND statusAtivo = true");
        consulta.setParameter("id", i);
        return consulta.list();
    }
        
    public Long salvarRetornaId(Quiz entidade, Session sessao) throws HibernateException {
		return (Long) sessao.save(entidade);
	}

	@Override
	public List<Quiz> buscaQuizzesPublicos(Usuario usuario, Session sessao) {
		logger.info("método buscaQuizzesPublicos()");
		if (null == usuario.getId()) {
			Query consulta = sessao.createQuery("FROM Quiz WHERE statusAtivo = true and visibilidadePrivada = false");
			return consulta.list();			
		} else {
			Query consulta = sessao.createQuery("FROM Quiz WHERE "
					+ "(status_ativo = true and visibilidade_privada = false)"
					+ " or id_usuario_proprietario = :id");
			consulta.setParameter("id", usuario.getId());
			return consulta.list();
		}
	}

    @Override
        public boolean setStatusAtivoFalse(Session sessao, Long id) {
          Query query = sessao.createQuery("update Quiz set statusAtivo = false where id = :id");
          query.setParameter("id", id);
          int result = query.executeUpdate();
          return result > 0;
        }

}
