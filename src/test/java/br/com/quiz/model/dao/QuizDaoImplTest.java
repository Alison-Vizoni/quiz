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

import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.Quiz;
import br.com.quiz.model.entidade.SubCategoria;
import br.com.quiz.model.entidade.Usuario;

public class QuizDaoImplTest {
	
	private Session sessao;
	private Pergunta pergunta;
	private Usuario usuario;
	private Categoria categoria;
	private Quiz quiz;
	private QuizDao quizDao;
	private final Logger LOG = Logger.getLogger(QuizDaoImplTest.class.getName());
	
	public QuizDaoImplTest() {
		quizDao = new QuizDaoImpl();
		buscarCategoria();
		buscarUsuario();
		buscarPergunta();
	}
	
	@Test
	public void testSalvar(){
        LOG.info("Test salvar quiz");
        
        quiz = new Quiz(
        		gerarCaracter(10), true,
        		false, Date.from(Instant.now()));
        
        quiz.setUsuarioProprietario(usuario);
        quiz.setCategorias(Set.of(categoria));
        quiz.setPerguntas(List.of(pergunta));
        
        sessao = HibernateUtil.abrirSessao();
        quizDao.salvarOuAlterar(quiz, sessao);
        sessao.close();
        
        assertNotNull(quiz.getId());
    }

    @Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id quiz");
        buscarQuizNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        Quiz quizPorId = quizDao.pesquisarPorId(quiz.getId(), sessao);
        sessao.close();
        
        assertNotNull(quizPorId);
    }
    
    @Test
    public void testAlterar(){
        LOG.info("test alterar quiz");
        buscarQuizNoBancoDeDados();
        quiz.setTitulo(gerarCaracter(20));
        
        sessao = HibernateUtil.abrirSessao();
        quizDao.salvarOuAlterar(quiz, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        Quiz quizAlterada = quizDao.pesquisarPorId(quiz.getId(), sessao);
        sessao.close();
        
        assertEquals(quiz.getTitulo(), quizAlterada.getTitulo());
    }
    
    @Test
    public void testExcluir(){
        LOG.info("Test excluir quiz");
        
        quiz = new Quiz(
        		gerarCaracter(10), true,
        		false, Date.from(Instant.now()));
        
        quiz.setUsuarioProprietario(usuario);
        quiz.setCategorias(Set.of(categoria));
        quiz.setPerguntas(List.of(pergunta));
        
        sessao = HibernateUtil.abrirSessao();
        quizDao.salvarOuAlterar(quiz, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        quizDao.excluir(quiz, sessao);
        
        Quiz quizExcluido = quizDao.pesquisarPorId(quiz.getId(), sessao);
        sessao.close();
        
        assertNull(quizExcluido);
    }
    
    public Quiz buscarQuizNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from Quiz");
        consulta.setMaxResults(10);
        List<Quiz> quizzes = consulta.list();
        sessao.close();
        
        if(quizzes.isEmpty()){
            testSalvar();
        } else {
        	quiz = quizzes.get(0);
        }
        return quiz;
    }
    
    public void buscarCategoria() {
    	CategoriaDaoImplTest categoriaDaoImplTest = new CategoriaDaoImplTest();
    	categoria = categoriaDaoImplTest.buscarCategoriaNoBancoDeDados();
    }
    
    public void buscarUsuario() {
    	UsuarioDaoImplTest usuarioDaoImplTest = new UsuarioDaoImplTest();
    	usuario = usuarioDaoImplTest.buscarUsuarioNoBancoDeDados();
    }
    
    public void buscarPergunta() {
    	PerguntaDaoImplTest perguntaDaoImplTest = new PerguntaDaoImplTest();
    	pergunta = perguntaDaoImplTest.buscarPerguntaNoBancoDeDados();
    }
}
