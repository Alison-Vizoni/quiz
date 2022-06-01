package br.com.quiz.model.dao;

import static br.com.quiz.util.GeradorUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.SubCategoria;
import br.com.quiz.model.entidade.Usuario;

public class PerguntaDaoImplTest {
	
	private SubCategoria subCategoria;
	private Session sessao;
	private PerguntaDao perguntaDao;
	private Pergunta pergunta;
	private Usuario usuario;
	private final Logger LOG = Logger.getLogger(PerguntaDaoImplTest.class.getName());
	
	public PerguntaDaoImplTest() {
		perguntaDao = new PerguntaDaoImpl();
		buscarSubCategoria();
		buscarUsuario();
	}
	
	@Test
	public void testSalvar(){
        LOG.info("Test salvar pergunta");
        
        pergunta = new Pergunta(
        	gerarCaracter(20),
        	true, false,
        	Date.from(Instant.now())
        );
        
        pergunta.setUsuarioProprietario(usuario);
        pergunta.setSubCategoria(subCategoria);
        
        sessao = HibernateUtil.abrirSessao();
        perguntaDao.salvarOuAlterar(pergunta, sessao);
        sessao.close();
        
        assertNotNull(subCategoria.getId());
    }

    @Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id pergunta");
        buscarPerguntaNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        Pergunta perguntaPorId = perguntaDao.pesquisarPorID(pergunta.getId(), sessao);
        sessao.close();
        
        assertNotNull(perguntaPorId);
    }
    
    @Test
    public void testAlterar(){
        LOG.info("test alterar pergunta");
        buscarPerguntaNoBancoDeDados();
        pergunta.setTexto(gerarCaracter(20));
        
        sessao = HibernateUtil.abrirSessao();
        perguntaDao.salvarOuAlterar(pergunta, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        Pergunta perguntaAlterada = perguntaDao.pesquisarPorID(pergunta.getId(), sessao);
        sessao.close();
        
        assertEquals(pergunta.getTexto(), perguntaAlterada.getTexto());
    }
    
    @Test
    public void testExcluir(){
        LOG.info("Test excluir pergunta");
        
        pergunta = new Pergunta(
            	gerarCaracter(20),
            	true, false,
            	Date.from(Instant.now())
            );
            
            pergunta.setUsuarioProprietario(usuario);
            pergunta.setSubCategoria(subCategoria);
        
        sessao = HibernateUtil.abrirSessao();
        perguntaDao.salvarOuAlterar(pergunta, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        perguntaDao.excluir(pergunta, sessao);
        
        Pergunta perguntaExcluida = perguntaDao.pesquisarPorID(pergunta.getId(), sessao);
        sessao.close();
        
        assertNull(perguntaExcluida);
    }
    
    public Pergunta buscarPerguntaNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from Pergunta");
        consulta.setMaxResults(10);
        List<Pergunta> perguntas = consulta.list();
        sessao.close();
        
        if(perguntas.isEmpty()){
            testSalvar();
        } else {
        	pergunta = perguntas.get(0);
        }
        return pergunta;
    }
    
    public void buscarSubCategoria() {
    	SubCategoriaDaoImplTest subCategoriaDaoImplTest = new SubCategoriaDaoImplTest();
    	subCategoria = subCategoriaDaoImplTest.buscarSubCategoriaNoBancoDeDados();
    }
    
    public void buscarUsuario() {
    	UsuarioDaoImplTest usuarioDaoImplTest = new UsuarioDaoImplTest();
    	usuario = usuarioDaoImplTest.buscarUsuarioNoBancoDeDados();
    }
}
