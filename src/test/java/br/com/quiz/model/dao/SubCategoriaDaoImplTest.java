package br.com.quiz.model.dao;

import static br.com.quiz.util.GeradorUtil.gerarNomeSubCategoria;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.SubCategoria;

public class SubCategoriaDaoImplTest {
	
	private Categoria categoria;
	private SubCategoria subCategoria;
	private Session sessao;
	private SubCategoriaDao subCategoriaDao;
	private final Logger LOG = Logger.getLogger(SubCategoriaDaoImpl.class.getName());
	
	public SubCategoriaDaoImplTest() {
		subCategoriaDao = new SubCategoriaDaoImpl();
		buscarCategoria();
	}
	
	@Test
	public void testSalvar(){
        LOG.info("Test salvar sub categoria");
        
        subCategoria = new SubCategoria(gerarNomeSubCategoria());
        
        subCategoria.setCategoria(categoria);
        
        sessao = HibernateUtil.abrirSessao();
        subCategoriaDao.salvarOuAlterar(subCategoria, sessao);
        sessao.close();
        
        assertNotNull(subCategoria.getId());
    }

    @Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id sub categoria");
        buscarSubCategoriaNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        SubCategoria subCategoriaPorId = subCategoriaDao.pesquisarPorId(subCategoria.getId(), sessao);
        sessao.close();
        
        assertNotNull(subCategoriaPorId);
    }

    @Test
    public void testPesquisarPorNome() {
        LOG.info("Test pesquisar por nome sub categoria");
        buscarSubCategoriaNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        List<SubCategoria> subCategoriaPorNome = subCategoriaDao.pesquisarPorNome(subCategoria.getNome(), sessao);
        sessao.close();
        
        assertFalse(subCategoriaPorNome.isEmpty());
    }
    
    @Test
    public void testAlterar(){
        LOG.info("test alterar sub categoria");
        buscarSubCategoriaNoBancoDeDados();
        subCategoria.setNome(gerarNomeSubCategoria());
        
        sessao = HibernateUtil.abrirSessao();
        subCategoriaDao.salvarOuAlterar(subCategoria, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        SubCategoria subCategoriaAlterada = subCategoriaDao.pesquisarPorId(subCategoria.getId(), sessao);
        sessao.close();
        
        assertEquals(subCategoria.getNome(), subCategoriaAlterada.getNome());
    }
    
    @Test
    public void testExcluir(){
        LOG.info("Test excluir sub categoria");
        
        subCategoria = new SubCategoria(gerarNomeSubCategoria());
        subCategoria.setCategoria(categoria);
        
        sessao = HibernateUtil.abrirSessao();
        subCategoriaDao.salvarOuAlterar(subCategoria, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        subCategoriaDao.excluir(subCategoria, sessao);
        
        SubCategoria subCategoriaExcluida = subCategoriaDao.pesquisarPorId(subCategoria.getId(), sessao);
        sessao.close();
        
        assertNull(subCategoriaExcluida);
    }
    
    public SubCategoria buscarSubCategoriaNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from SubCategoria");
        consulta.setMaxResults(10);
        List<SubCategoria> subCategorias = consulta.list();
        sessao.close();
        
        if(subCategorias.isEmpty()){
            testSalvar();
        } else {
        	subCategoria = subCategorias.get(0);
        }
        return subCategoria;
    }
    
    public void buscarCategoria() {
    	CategoriaDaoImplTest categoriaDaoImplTest = new CategoriaDaoImplTest();
    	categoria = categoriaDaoImplTest.buscarCategoriaNoBancoDeDados();
    }
}
