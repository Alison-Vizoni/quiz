/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.SubCategoria;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public interface SubCategoriaDao extends BaseDao<SubCategoria, Long>{
    
    List<SubCategoria> pesquisarPorNome(String nome, Session sessao)
            throws HibernateException;

    List<SubCategoria> populaComboInicial(Session sessao);
    
    SubCategoria buscaNomeEspecifico(String nome, Session sessao);

	List<SubCategoria> buscaPorCategoria(Categoria categoria, Session sessao);
	
	List<SubCategoria> pesquisarPorIdCategoria(Long id_categoria, Session sessao);
    
}
