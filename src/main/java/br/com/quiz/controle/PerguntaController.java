
package br.com.quiz.controle;

import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.PerguntaDao;
import br.com.quiz.model.dao.PerguntaDaoImpl;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Pergunta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
    
    private CategoriaDao categoriaDao = new CategoriaDaoImpl();
    private Categoria categoria;
    
    private List<Alternativa> listaAlternativas = new ArrayList<>();
    private DataModel<Alternativa> modelAlternativas;
    private Alternativa alternativa;
    private Alternativa alter;
    
    private Long contadorId = 0L;
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
    
    //Tratamento View Alternativas
    
     /**
     * Insere alternativas na tabela
     */
    public void populaListaAlternativa() {
        if (!alternativa.getTexto().isBlank()) {
            alternativa.setId(contadorId++);
            listaAlternativas.add(alternativa);
            apresentaTabela();
            alternativa = null;
        } else {
            Mensagem.sucesso("Texto da alternativa não pode ser vazio!");
        }
    }

    /**
     * Apresenta na tela as alternativas cadastradas
     */
    public void apresentaTabela() {
        try {
            modelAlternativas = new ListDataModel<>(listaAlternativas);
        } catch (HibernateException e) {
            System.out.println("Método apresentaTabela() - \n Erro ao incluir alternativa na tabela [" + e.getMessage() + "]");
        }
    }

    /**
     * Exclui alternativa da tabela
     */
    public void excluir() {
        alter = new Alternativa();
        alter = modelAlternativas.getRowData();
        listaAlternativas.removeIf(alt -> alt.equals(alter));
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

    public List<Alternativa> getListaAlternativas() {
        return listaAlternativas;
    }

    public void setListaAlternativas(List<Alternativa> listaAlternativas) {
        this.listaAlternativas = listaAlternativas;
    }

    public CategoriaDao getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public DataModel<Alternativa> getModelAlternativas() {
        return modelAlternativas;
    }

    public void setModelAlternativas(DataModel<Alternativa> modelAlternativas) {
        this.modelAlternativas = modelAlternativas;
    }

    public Alternativa getAlternativa() {
        if (alternativa == null) {
            alternativa = new Alternativa();
        }
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public Alternativa getAlter() {
        return alter;
    }

    public void setAlter(Alternativa alter) {
        this.alter = alter;
    }

    public Long getContadorId() {
        return contadorId;
    }

    public void setContadorId(Long contadorId) {
        this.contadorId = contadorId;
    }
    
}
