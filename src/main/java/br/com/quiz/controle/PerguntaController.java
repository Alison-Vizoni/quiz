
package br.com.quiz.controle;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.PerguntaDao;
import br.com.quiz.model.dao.PerguntaDaoImpl;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "perguntaC")
@ViewScoped
public class PerguntaController implements Serializable{

    private PerguntaDao perguntaDao;
    private Pergunta pergunta;
    
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
    
    // CRUD
    
    public void salvar() {
        sessao = HibernateUtil.abrirSessao();
        
        try {
            
         

        } catch (HibernateException e) {
            System.err.println("Erro ao salvar " + e.getMessage());
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
    
}
