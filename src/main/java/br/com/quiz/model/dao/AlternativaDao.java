/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Pergunta;

/**
 *
 * @author alison
 */
public interface AlternativaDao extends BaseDao<Alternativa, Long>{

	List<Alternativa> pesquisarPorPergunta(Pergunta pergunta, Session sessao);
}
