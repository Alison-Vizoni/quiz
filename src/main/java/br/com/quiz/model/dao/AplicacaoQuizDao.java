/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import br.com.quiz.model.entidade.AplicacaoQuiz;

/**
 *
 * @author alison
 */
public interface AplicacaoQuizDao extends BaseDao<AplicacaoQuiz, Long>{
	
	AplicacaoQuiz pesquisarPorId(Long id, Session sessao);

	boolean verificarPermissaoParaResponderAplicacaoQuiz(Long idAplicacaoQuiz, String email, Session sessao);

	boolean usuarioJaRespondeuQuiz(Long idAplicacaoQuiz, Long idUsuario, Session sessao);
	
	List<AplicacaoQuiz> buscarQuizzesAplicados(Long id_usuario_logado, Session sessao);
}
