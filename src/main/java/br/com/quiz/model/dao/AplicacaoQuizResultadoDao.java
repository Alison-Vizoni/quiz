/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.quiz.model.entidade.AplicacaoQuizResultado;

/**
 *
 * @author alison
 */
public interface AplicacaoQuizResultadoDao extends BaseDao<AplicacaoQuizResultado, Long>{
	
	List<AplicacaoQuizResultado> pesquisarPorIdAplicacaoQuiz(Long idAplicacaoQuiz, Session sessao);
	
	List<AplicacaoQuizResultado> pesquisarPorId(Long idAplicacaoQuiz, Long idUsuario, Session sessao);

	AplicacaoQuizResultado pesquisarPorId(Long idAplicacaoQuiz, Long idUsuario, Long idAlternativa, Session sessao);
}
