package br.com.quiz.model.dao;

import static br.com.quiz.util.GeradorUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.AplicacaoQuizResultado;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import br.com.quiz.model.entidade.SubCategoria;
import br.com.quiz.model.entidade.Usuario;

public class AplicacaoQuizResultadoDaoImplTest {
	
	private Session sessao;
	private Usuario usuario;
	private AplicacaoQuiz aplicacaoQuiz;
	private Alternativa alternativa;
	private AplicacaoQuizResultado aplicacaoQuizResultado;
	private AplicacaoQuizResultadoDao aplicacaoQuizResultadoDao;
	private final Logger LOG = Logger.getLogger(AplicacaoQuizResultadoDaoImplTest.class.getName());
	
	public AplicacaoQuizResultadoDaoImplTest() {
		aplicacaoQuizResultadoDao = new AplicacaoQuizResultadoDaoImpl();
		buscarUsuario();
		buscarAlternativa();
		buscarAplicacaoQuiz();
	}
	
	@Test
	public void testSalvar(){
        LOG.info("Test salvar aplicacao quiz resultado");
        
        aplicacaoQuizResultado = new AplicacaoQuizResultado(Date.from(Instant.now()));
        
        aplicacaoQuizResultado.setAplicacaoQuiz(aplicacaoQuiz);
        aplicacaoQuizResultado.setUsuario(usuario);
        aplicacaoQuizResultado.setAlternativa(alternativa);
        
        sessao = HibernateUtil.abrirSessao();
        aplicacaoQuizResultadoDao.salvarOuAlterar(aplicacaoQuizResultado, sessao);
        sessao.close();
        
        assertNotNull(aplicacaoQuizResultado.getId());
    }
	
// TODO verificar soluções para o pesquisar por id
//    @Test
//    public void testPesquisarPorID() {
//        LOG.info("Test pesquisar por id aplicacao quiz resultado");
//        buscarAplicacaoQuizResultadoNoBancoDeDados();
//        
//        sessao = HibernateUtil.abrirSessao();
//        AplicacaoQuizResultado aplicacaoQuizResultadoPorId = aplicacaoQuizResultadoDao.pesquisarPorID(aplicacaoQuizResultado.getId(), sessao);
//        sessao.close();
//        
//        assertNotNull(aplicacaoQuizResultadoPorId);
//    }
//    
//    @Test
//    public void testAlterar(){
//        LOG.info("test alterar aplicacao quiz resultado");
//        buscarAplicacaoQuizResultadoNoBancoDeDados();
//        aplicacaoQuizResultado.setDataResolucao(Date.from(Instant.now()));
//        
//        sessao = HibernateUtil.abrirSessao();
//        aplicacaoQuizResultadoDao.salvarOuAlterar(aplicacaoQuizResultado, sessao);
//        sessao.close();
//        
//        sessao = HibernateUtil.abrirSessao();
//        AplicacaoQuizResultado aplicacaoQuizResultadoAlterada = aplicacaoQuizResultadoDao.pesquisarPorID(aplicacaoQuizResultado.getId(), sessao);
//        sessao.close();
//        
//        assertEquals(aplicacaoQuizResultado.getDataResolucao(), aplicacaoQuizResultadoAlterada.getDataResolucao());
//    }
//    
//    @Test
//    public void testExcluir(){
//        LOG.info("Test excluir aplicacao quiz resultado");
//        
//        aplicacaoQuiz = new AplicacaoQuiz(
//        		Date.from(Instant.now()),
//        		gerarCaracter(20));
//        
//        aplicacaoQuiz.setQuiz(quiz);
//        aplicacaoQuiz.setUsuarioAplicador(usuario);
//        
//        sessao = HibernateUtil.abrirSessao();
//        aplicacaoQuizDao.salvarOuAlterar(aplicacaoQuiz, sessao);
//        sessao.close();
//        
//        sessao = HibernateUtil.abrirSessao();
//        aplicacaoQuizDao.excluir(aplicacaoQuiz, sessao);
//        
//        AplicacaoQuizResultado aplicacaoQuizExcluido = aplicacaoQuizDao.pesquisarPorID(aplicacaoQuiz.getId(), sessao);
//        sessao.close();
//        
//        assertNull(aplicacaoQuizExcluido);
//    }
    
    public AplicacaoQuizResultado buscarAplicacaoQuizResultadoNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from AplicacaoQuizResultado");
        consulta.setMaxResults(10);
        List<AplicacaoQuizResultado> aplicacaoQuizzesResultado = consulta.list();
        sessao.close();
        
        if(aplicacaoQuizzesResultado.isEmpty()){
            testSalvar();
        } else {
        	aplicacaoQuizResultado = aplicacaoQuizzesResultado.get(0);
        }
        return aplicacaoQuizResultado;
    }
    
    public void buscarUsuario() {
    	UsuarioDaoImplTest usuarioDaoImplTest = new UsuarioDaoImplTest();
    	usuario = usuarioDaoImplTest.buscarUsuarioNoBancoDeDados();
    }
    
    public void buscarAlternativa() {
    	AlternativaDaoImplTest alternativaDaoImplTest = new AlternativaDaoImplTest();
    	alternativa = alternativaDaoImplTest.buscarAlternativaNoBancoDeDados();
    }
    
    public void buscarAplicacaoQuiz() {
    	AplicacaoQuizDaoImplTest aplicacaoQuizDaoImplTest = new AplicacaoQuizDaoImplTest();
    	aplicacaoQuiz = aplicacaoQuizDaoImplTest.buscarAplicacaoQuizNoBancoDeDados();
    }
}
