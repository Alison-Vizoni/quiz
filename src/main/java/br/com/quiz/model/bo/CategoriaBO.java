/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.quiz.model.bo;

import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.exceptions.CategoriaJaExistenteException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alison
 */
public class CategoriaBO {
    
    private CategoriaDao categoriaDao;
    private Session sessao;

    public CategoriaBO() {
        categoriaDao = new CategoriaDaoImpl();
    }
    
    public Categoria salvarOuAlterar(Categoria categoria) throws CategoriaJaExistenteException{
        List<Categoria> verificarCategoriaRepetida = categoriaDao
                .pesquisarPorNome(categoria.getNome(), sessao);
        
        if(!verificarCategoriaRepetida.isEmpty()){
            throw new CategoriaJaExistenteException();
        }
        
        categoriaDao.salvarOuAlterar(categoria, sessao);
        
        return categoria;
    }
    
}
