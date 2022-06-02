package br.com.quiz.model.dao;

import static br.com.quiz.util.GeradorUtil.*;
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
import br.com.quiz.model.entidade.Usuario;

public class UsuarioDaoImplTest {

	private Session sessao;
	private Usuario usuario;
	private UsuarioDao usuarioDao;
	private final Logger LOG = Logger.getLogger(UsuarioDaoImplTest.class.getName());
	
	public UsuarioDaoImplTest() {
		usuarioDao = new UsuarioDaoImpl();
	}
	
	@Test
	public void testSalvar() {
		LOG.info("Test salvar usuario");
		
		String nome = gerarNome();
		usuario = new Usuario(nome, String.valueOf(gerarNumero(11)),
				nome + "@ex.com", gerarTeleCeluar(), true,
				nome, nome);
		
		sessao = HibernateUtil.abrirSessao();
		usuarioDao.salvarOuAlterar(usuario, sessao);
		sessao.close();
		
		assertNotNull(usuario.getId());
	}
	
	@Test
    public void testPesquisarPorID() {
        LOG.info("Test pesquisar por id usuario");
        buscarUsuarioNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        Usuario usuarioPorId = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        
        assertNotNull(usuarioPorId);
    }

    @Test
    public void testPesquisarPorNome() {
        LOG.info("Test pesquisar por nome usuario");
        
        buscarUsuarioNoBancoDeDados();
        
        sessao = HibernateUtil.abrirSessao();
        List<Usuario> usuarioPorNome = usuarioDao.pesquisarPorNome(usuario.getNome(), sessao);
        sessao.close();
        
        assertFalse(usuarioPorNome.isEmpty());
    }
    
    @Test
    public void testAlterar(){
        LOG.info("test alterar usuario");
        buscarUsuarioNoBancoDeDados();
        usuario.setNome(gerarNome());
        
        sessao = HibernateUtil.abrirSessao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        Usuario usuarioAlterada = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        
        assertEquals(usuario.getNome(), usuarioAlterada.getNome());
    }
    
    @Test
    public void testExcluir(){
        LOG.info("Test excluir usuario");
        
        String nome = gerarNome();
		usuario = new Usuario(nome, String.valueOf(gerarNumero(11)),
				nome + "@ex.com", gerarTeleCeluar(), true,
				nome, nome);
        
        sessao = HibernateUtil.abrirSessao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirSessao();
        usuarioDao.excluir(usuario, sessao);
        
        Usuario usuarioExcluida = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        
        assertNull(usuarioExcluida);
    }
	
	public Usuario buscarUsuarioNoBancoDeDados(){
        sessao = HibernateUtil.abrirSessao();
        Query consulta = sessao.createQuery("from Usuario");
        consulta.setMaxResults(10);
        List<Usuario> usuarios = consulta.list();
        sessao.close();
        
        if(usuarios.isEmpty()){
            testSalvar();
        } else {
            usuario = usuarios.get(0);
        }
        return usuario;
    }
}
