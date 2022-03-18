/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Categoria;
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
public class PerguntaDaoImpl extends BaseDaoImpl<Pergunta, Long> 
        implements PerguntaDao, Serializable{

	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.logger(getClass());

	@Override
    public Pergunta pesquisarPorID(Long id, Session sessao) 
            throws HibernateException {
                  logger.info("método pesquisarPorID()");
        return (Pergunta) sessao.get(Pergunta.class, id);
    }
	
	public List<Pergunta> buscaTodasPerguntas(Session sessao){
            logger.info("método buscaTodasPerguntas()");
		Query consulta = sessao.createQuery("FROM pergunta");
		return consulta.list();
		
	}

	@Override
	public List<Pergunta> buscaPerguntasPorCategoria(Categoria categoria, Session sessao) {
		logger.info("método buscaPerguntasPorCategoria()");
		Query consulta = sessao.createQuery("FROM Pergunta WHERE categoria = :categoria");
		consulta.setParameter("categoria", categoria);
		return consulta.list();
	}

    @Override
    public List<Pergunta> buscarPerguntasElaboradosPeloUsuario(Long idUsuarioLogado, Session sessao) {
        logger.info("método buscaPerguntasPorCategoria()");
        Query consulta = sessao.createQuery("FROM Pergunta WHERE usuarioProprietario = :idUsuarioLogado");
        consulta.setParameter("idUsuarioLogado", idUsuarioLogado);
        return consulta.list();
    }
    
}
