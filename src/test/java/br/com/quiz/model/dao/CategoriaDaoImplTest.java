/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.quiz.model.dao;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.entidade.Categoria;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import static br.com.quiz.util.GeradorUtil.*;
import org.hibernate.Query;

/**
 *
 * @author alison
 */
public class CategoriaDaoImplTest {
    
    private Categoria categoria;
    private Session sessao;
    private CategoriaDao categoriaDao;
    private final Logger LOG = Logger.getLogger(CategoriaDaoImplTest.class.getName());
    
    public CategoriaDaoImplTest() {
        categoriaDao = new CategoriaDaoImpl();
    }
    
//    @Test
    public void testSalvar(){
        LOG.info("Test salvar categoria");
        
        categoria = new Categoria(gerarNomeCategoria());
        
        sessao = HibernateUtil.abrirSessao();
        categoriaDao.salvarOuAlterar(categoria, sessao);
        sessao.close();
        
        assertNotNull(categoria.getId());
    }

//    @Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id categoria");
        buscarCategoriaNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        Categoria categoriaPorId = categoriaDao.pesquisarPorID(categoria.getId(), sessao);
        sessao.close();
        
        assertNotNull(categoriaPorId);
    }

//    @Test
    public void testPesquisarPorNome() {
        LOG.info("Test pesquisar por nome categoria");
        
        buscarCategoriaNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        List<Categoria> categoriaPorNome = categoriaDao.pesquisarPorNome(categoria.getNome(), sessao);
        sessao.close();
        
        assertFalse(categoriaPorNome.isEmpty());
    }
    
//    @Test
    public void testAlterar(){
        LOG.info("test alterar categoria");
        buscarCategoriaNoBancoDeDados();
        categoria.setNome(gerarNomeCategoria());
        
        sessao = HibernateUtil.abrirSessao();
        categoriaDao.salvarOuAlterar(categoria, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        Categoria categoriaAlterada = categoriaDao.pesquisarPorID(categoria.getId(), sessao);
        sessao.close();
        
        assertEquals(categoria.getNome(), categoriaAlterada.getNome());
    }
    
//    @Test
    public void testExcluir(){
        LOG.info("Test excluir categoria");
        
        categoria = new Categoria(gerarNomeCategoria());
        
        sessao = HibernateUtil.abrirSessao();
        categoriaDao.salvarOuAlterar(categoria, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        categoriaDao.excluir(categoria, sessao);
        
        Categoria categoriaExcluida = categoriaDao.pesquisarPorID(categoria.getId(), sessao);
        sessao.close();
        
        assertNull(categoriaExcluida);
    }
    
    public Categoria buscarCategoriaNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from Categoria");
        consulta.setMaxResults(10);
        List<Categoria> categorias = consulta.list();
        sessao.close();
        
        if(categorias.isEmpty()){
            testSalvar();
        } else {
            categoria = categorias.get(0);
        }
        return categoria;
    }
    
}
