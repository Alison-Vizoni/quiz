package br.com.quiz.controle;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.primefaces.event.FlowEvent;

import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.PerguntaDao;
import br.com.quiz.model.dao.PerguntaDaoImpl;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "perguntaC")
@ViewScoped
public class PerguntaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PerguntaDao perguntaDao;
    private Pergunta pergunta;
    
    private CategoriaDao categoriaDao = new CategoriaDaoImpl();
    private Categoria categoria;
    
    private Session sessao;
    private boolean skip;    

    public PerguntaController() {
        perguntaDao = new PerguntaDaoImpl();
       
    }
       
    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; 
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    /**
     * Vincula a categoria selecionada no comboBox com a pergunta
     */
    public void setaCategoria(){
        try {
            sessao = HibernateUtil.abrirSessao();   
            categoria = categoriaDao.pesquisarPorID(categoria.getId(), sessao);
        } catch (HibernateException e) {
            System.out.println("método setaCategoria - Erro ao vincular categoria na pergunta " + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    /**
     * Atualiza o status de visibilidade da questão
     */
    public void defineStatusVisibilidade(){
        System.out.println("teste " + pergunta.isVisibilidadePrivada());
    }
    
    // CRUD
    
    public void salvar() {
        
        try {
            sessao = HibernateUtil.abrirSessao();
            pergunta.setCategoria(categoria);
            Date criacao =  new Date(System.currentTimeMillis());            
            pergunta.setDataCriacao(criacao); 
            perguntaDao.salvarOuAlterar(pergunta, sessao);           

        } catch (HibernateException e) {
            System.out.println("Erro ao salvar " + e.getMessage());
        } finally {
            sessao.close();
        }
    }    
    
    // getters and setters
    
     public Pergunta getPergunta() {
         if (pergunta == null) {
             pergunta = new Pergunta();
         }
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
    
    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public PerguntaDao getPerguntaDao() {
        return perguntaDao;
    }

    public void setPerguntaDao(PerguntaDao perguntaDao) {
        this.perguntaDao = perguntaDao;
    }

    public Categoria getCategoria() {        
        if (categoria == null) {
             categoria = new Categoria();
         }        
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public CategoriaDao getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
}
