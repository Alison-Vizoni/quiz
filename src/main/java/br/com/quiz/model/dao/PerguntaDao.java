/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;

/**
 *
 * @author alison
 */
public interface PerguntaDao extends BaseDao<Pergunta, Long>{

    List<Pergunta> buscaTodasPerguntas(Session sessao);

    List<Pergunta> buscaPerguntasPorCategoria(Categoria categoria, Session sessao);

    List<Pergunta> buscaPerguntasPorSubCategoria(Long idSubCategoria, Session sessao);
    
    List<Pergunta> buscarPerguntasElaboradosPeloUsuario(Long idSubCategoria, Session sessao);

}
