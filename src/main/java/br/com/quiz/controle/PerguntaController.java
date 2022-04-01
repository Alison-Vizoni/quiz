package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

import br.com.quiz.model.dao.AlternativaDao;
import br.com.quiz.model.dao.AlternativaDaoImpl;
import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.PerguntaDao;
import br.com.quiz.model.dao.PerguntaDaoImpl;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.Login;
import br.com.quiz.model.entidade.Pergunta;
import br.com.quiz.model.entidade.SubCategoria;
import javax.faces.model.SelectItem;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "perguntaC")
@ViewScoped
public class PerguntaController implements Serializable{

    private static final long serialVersionUID = 1L;

    private final Logger logger = LoggerFactory.logger(getClass());

    private PerguntaDao perguntaDao;
    private Pergunta pergunta;
    
    private DataModel<Pergunta> modelPerguntas;
    private List<Pergunta> perguntas = new ArrayList<>();
    
    private CategoriaDao categoriaDao = new CategoriaDaoImpl();
    private Categoria categoria;
    private SubCategoria subCategoria;
    
    private List<Alternativa> listaAlternativas = new ArrayList<>();
    
    private Login login;
    
    private Session sessao;
    private boolean skip;    

    public PerguntaController() {
    	logger.info("entrou na PerguntaController");
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
     * @param comboCategorias
     */
    public void setCategoriaVinculadaPergunta(List<SelectItem> comboCategorias){
        comboCategorias.stream()
                .filter(comboCategoria -> (comboCategoria.getValue() == categoria.getId()))
                .forEachOrdered(comboCategoria -> {categoria.setNome(comboCategoria.getLabel());});
    }
    
    /**
     * Atualiza o status de visibilidade da questão
     */
    public void defineStatusVisibilidade(){
        System.out.println("teste " + pergunta.isVisibilidadePrivada());
    }
    
    public void onRowSelect(SelectEvent<Pergunta> event) {
        FacesMessage msg = new FacesMessage("Pergunta Selected", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public Pergunta getRowData(String rowKey) {
    	logger.info("método - getRowData()");
        for (Pergunta perg : perguntas) {
            if (perg.getId() == Integer.parseInt(rowKey)) {
                return perg;
            }
        }

        return null;
    }
    
    // CRUD
    
    public void salvar() {
    	logger.info("método - salvar()");
    	
        try {
            sessao = HibernateUtil.abrirSessao();
            pergunta.setSubCategoria(subCategoria);
//            pergunta.setUsuarioProprietario(login.getUsuario());
            Date criacao =  new Date(System.currentTimeMillis());            
            pergunta.setDataCriacao(criacao); 
            perguntaDao.salvarOuAlterar(pergunta, sessao);           

        } catch (HibernateException e) {
        	logger.error("Erro ao salvar - " + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    public void buscaPerguntasPorCategoria() {
    	logger.info("método - buscaPerguntaPorCategoria()");
        try {
            sessao = HibernateUtil.abrirSessao();
            perguntas = perguntaDao.buscaPerguntasPorCategoria(categoria, sessao);
            modelPerguntas = new ListDataModel<>(perguntas);
        } catch (HibernateException e) {
            logger.error("erro na busca de perguntas por categoria " + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    public void buscarPerguntasElaboradasPeloUsuario(){
        logger.info("método - buscarPerguntasElaboradasPeloUsuario()");
        
        Long idUsuarioLogado = 1L;
        
        try {
            sessao = HibernateUtil.abrirSessao();
            perguntas = perguntaDao.buscarPerguntasElaboradosPeloUsuario(idUsuarioLogado, sessao);
            modelPerguntas = new ListDataModel<>(perguntas);
        } catch (HibernateException e) {
            logger.error("erro na busca de perguntas por usuario " + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    public void buscarPerguntasPorSubCategoria(){
        logger.info("método - buscaPerguntaPorSubCategoria()");
        
        try {
            sessao = HibernateUtil.abrirSessao();
            perguntas = perguntaDao.buscaPerguntasPorSubCategoria(subCategoria.getId(), sessao);
            modelPerguntas = new ListDataModel<>(perguntas);
        } catch (HibernateException e) {
            logger.error("erro na busca de perguntas por sub categoria " + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    // GETTERS AND SETTERS
    
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

    public SubCategoria getSubCategoria() {
        if(subCategoria == null){
            subCategoria = new SubCategoria();
        }
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
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

	public Login getLogin() {
		if (login == null) {
			login = new Login();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	public DataModel<Pergunta> getModelPerguntas() {
		return modelPerguntas;
	}

	public void setModelPerguntas(DataModel<Pergunta> modelPerguntas) {
		this.modelPerguntas = modelPerguntas;
	}

	public List<Alternativa> getListaAlternativas() {
		return listaAlternativas;
	}

	public void setListaAlternativas(List<Alternativa> listaAlternativas) {
		this.listaAlternativas = listaAlternativas;
	}
	
}
