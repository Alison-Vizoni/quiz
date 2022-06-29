/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public interface QuizDao extends BaseDao<Quiz, Long>{

    public List<Quiz> buscarQuizPorUsuario(Session sessao, Long i);

    public List<Quiz> pesquisarPorIdQuiz(Session sessao, Long idQuiz);

	public List<Quiz> buscaPerguntasPublicas(Session sessao);
    
}
