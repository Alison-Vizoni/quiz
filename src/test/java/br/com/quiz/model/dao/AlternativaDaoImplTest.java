package br.com.quiz.model.dao;

import static br.com.quiz.util.GeradorUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Pergunta;

public class AlternativaDaoImplTest {
	
	private Session sessao;
	private Pergunta pergunta;
	private Alternativa alternativa;
	private AlternativaDao alternativaDao;
	private final Logger LOG = Logger.getLogger(AlternativaDaoImplTest.class.getName());
	
	public AlternativaDaoImplTest() {
		alternativaDao = new AlternativaDaoImpl();
		buscarPergunta();
	}
	
	@Test
	public void testSalvar(){
        LOG.info("Test salvar alternativa");
        
        alternativa = new Alternativa(
        	gerarCaracter(10),
        	true,
        	true
        	);
        alternativa.setPergunta(pergunta);
        
        sessao = HibernateUtil.abrirSessao();
        alternativaDao.salvarOuAlterar(alternativa, sessao);
        sessao.close();
        
        assertNotNull(alternativa.getId());
    }

    @Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id alternativa");
        buscarAlternativaNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        Alternativa alternativaPorId = alternativaDao.pesquisarPorId(alternativa.getId(), sessao);
        sessao.close();
        
        assertNotNull(alternativaPorId);
    }
    
    @Test
    public void testAlterar(){
        LOG.info("test alterar alternativa");
        buscarAlternativaNoBancoDeDados();
        alternativa.setTexto(gerarCaracter(20));
        
        sessao = HibernateUtil.abrirSessao();
        alternativaDao.salvarOuAlterar(alternativa, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        Alternativa alternativaAlterada = alternativaDao.pesquisarPorId(alternativa.getId(), sessao);
        sessao.close();
        
        assertEquals(alternativa.getTexto(), alternativaAlterada.getTexto());
    }
    
    @Test
    public void testExcluir(){
        LOG.info("Test excluir alternativa");
        
        alternativa = new Alternativa(
            	gerarCaracter(10),
            	true,
            	true
            	);
        alternativa.setPergunta(pergunta);
            
        sessao = HibernateUtil.abrirSessao();
        alternativaDao.salvarOuAlterar(alternativa, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        alternativaDao.excluir(alternativa, sessao);
        
        Alternativa alternativaExcluida = alternativaDao.pesquisarPorId(alternativa.getId(), sessao);
        sessao.close();
        
        assertNull(alternativaExcluida);
    }
    
    public Alternativa buscarAlternativaNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from Alternativa");
        consulta.setMaxResults(10);
        List<Alternativa> alternativas = consulta.list();
        sessao.close();
        
        if(alternativas.isEmpty()){
            testSalvar();
        } else {
        	alternativa = alternativas.get(0);
        }
        return alternativa;
    }
    
    public void buscarPergunta() {
    	PerguntaDaoImplTest perguntaDaoImplTest = new PerguntaDaoImplTest();
    	pergunta = perguntaDaoImplTest.buscarPerguntaNoBancoDeDados();
    }
}
