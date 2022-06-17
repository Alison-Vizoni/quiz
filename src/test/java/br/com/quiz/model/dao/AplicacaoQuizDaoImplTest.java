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

import br.com.quiz.model.entidade.AplicacaoQuiz;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import br.com.quiz.model.entidade.SubCategoria;
import br.com.quiz.model.entidade.Usuario;

public class AplicacaoQuizDaoImplTest {
	
	private Session sessao;
	private Usuario usuario;
	private Quiz quiz;
	private AplicacaoQuiz aplicacaoQuiz;
	private AplicacaoQuizDao aplicacaoQuizDao;
	private final Logger LOG = Logger.getLogger(AplicacaoQuizDaoImplTest.class.getName());
	
	public AplicacaoQuizDaoImplTest() {
		aplicacaoQuizDao = new AplicacaoQuizDaoImpl();
		buscarUsuario();
		buscarQuiz();
	}
	
	@Test
	public void testSalvar(){
        LOG.info("Test salvar aplicacao quiz");
        
        aplicacaoQuiz = new AplicacaoQuiz(Date.from(Instant.now()));
        
        aplicacaoQuiz.setQuiz(quiz);
        aplicacaoQuiz.setUsuarioAplicador(usuario);
        
        sessao = HibernateUtil.abrirSessao();
        aplicacaoQuizDao.salvarOuAlterar(aplicacaoQuiz, sessao);
        sessao.close();
        
        assertNotNull(aplicacaoQuiz.getId());
    }

    @Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id aplicacao quiz");
        buscarAplicacaoQuizNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        AplicacaoQuiz aplicacaoQuizPorId = aplicacaoQuizDao.pesquisarPorId(aplicacaoQuiz.getId(), sessao);
        sessao.close();
        
        assertNotNull(aplicacaoQuizPorId);
    }
    
    @Test
    public void testAlterar(){
        LOG.info("test alterar aplicacao quiz");
        buscarAplicacaoQuizNoBancoDeDados();
        aplicacaoQuiz.setDataAplicacao(Date.from(Instant.now()));
        
        sessao = HibernateUtil.abrirSessao();
        aplicacaoQuizDao.salvarOuAlterar(aplicacaoQuiz, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        AplicacaoQuiz aplicacaoQuizAlterada = aplicacaoQuizDao.pesquisarPorId(aplicacaoQuiz.getId(), sessao);
        sessao.close();
        
        assertEquals(aplicacaoQuiz.getDataAplicacao(), aplicacaoQuizAlterada.getDataAplicacao());
    }
    
    @Test
    public void testExcluir(){
        LOG.info("Test excluir aplicacao quiz");
        
        aplicacaoQuiz = new AplicacaoQuiz(Date.from(Instant.now()));
        
        aplicacaoQuiz.setQuiz(quiz);
        aplicacaoQuiz.setUsuarioAplicador(usuario);
        
        sessao = HibernateUtil.abrirSessao();
        aplicacaoQuizDao.salvarOuAlterar(aplicacaoQuiz, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        aplicacaoQuizDao.excluir(aplicacaoQuiz, sessao);
        
        AplicacaoQuiz aplicacaoQuizExcluido = aplicacaoQuizDao.pesquisarPorId(aplicacaoQuiz.getId(), sessao);
        sessao.close();
        
        assertNull(aplicacaoQuizExcluido);
    }
    
    public AplicacaoQuiz buscarAplicacaoQuizNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from AplicacaoQuiz");
        consulta.setMaxResults(10);
        List<AplicacaoQuiz> aplicacaoQuizzes = consulta.list();
        sessao.close();
        
        if(aplicacaoQuizzes.isEmpty()){
            testSalvar();
        } else {
        	aplicacaoQuiz = aplicacaoQuizzes.get(0);
        }
        return aplicacaoQuiz;
    }
    
    public void buscarUsuario() {
    	UsuarioDaoImplTest usuarioDaoImplTest = new UsuarioDaoImplTest();
    	usuario = usuarioDaoImplTest.buscarUsuarioNoBancoDeDados();
    }
    
    public void buscarQuiz() {
    	QuizDaoImplTest quizDaoImplTest = new QuizDaoImplTest();
    	quiz = quizDaoImplTest.buscarQuizNoBancoDeDados();
    }
}
