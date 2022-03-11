package br.com.quiz.controle;

import br.com.quiz.model.dao.AlternativaDao;
import br.com.quiz.model.dao.AlternativaDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.PerguntaDao;
import br.com.quiz.model.dao.PerguntaDaoImpl;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Pergunta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;


/**
 *
 * @author alf_a
 */
@ManagedBean(name = "alternativaC")
@ViewScoped
public class AlternativaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.logger(getClass());
	
	private List<Alternativa> listaAlternativas = new ArrayList<>();
    private DataModel<Alternativa> modelAlternativas;
    private AlternativaDao alternativaDao;
    private Alternativa alternativa;
    private Alternativa alter;
    
    private PerguntaDao perguntaDao;
    
    private Long contadorId = 0L;
    private Pergunta pergunta;
    private Session sessao;

    public AlternativaController() {        
        alternativaDao = new AlternativaDaoImpl();       
    }

    /**
     * Insere alternativas na tabela
     */
    public void populaListaAlternativa() {
        if (alternativa.getTexto() != null && alternativa.getTexto().trim().length() != 0) {
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
        	logger.error("Método apresentaTabela() - " + e.getMessage());
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

    // CRUD
    
    public void salvar(Long id){
    	logger.info("método salvar()");
    	
        try {
            perguntaDao = new PerguntaDaoImpl();
            sessao = HibernateUtil.abrirSessao();
            pergunta = perguntaDao.pesquisarPorID(id, sessao);
            
            for (Alternativa altern : listaAlternativas) {
             altern.setPergunta(pergunta);
             altern.setId(null);
             alternativaDao.salvarOuAlterar(altern, sessao);
            }

        } catch (HibernateException e) {
        	logger.error("método salvar() - " + e.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    public void buscaAlternativasPorPergunta(Pergunta pergunta) {
    	logger.info("método buscaAlternativasPorPergunta()");
    	
    	try {
            perguntaDao = new PerguntaDaoImpl();
            sessao = HibernateUtil.abrirSessao();
            listaAlternativas = alternativaDao.pesquisarPorPergunta(pergunta, sessao);            

        } catch (HibernateException e) {
        	logger.error("método buscaAlternativasPorPergunta() - " + e.getMessage());
        } finally {
            sessao.close();
        }
    	
    }
    
    // GETTERS AND SETTERS
    public Alternativa getAlternativa() {
        if (alternativa == null) {
            alternativa = new Alternativa();
        }
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public List<Alternativa> getListaAlternativas() {
        return listaAlternativas;
    }

    public void setListaAlternativas(List<Alternativa> listaAlternativas) {
        this.listaAlternativas = listaAlternativas;
    }

    public AlternativaDao getAlternativaDao() {
        return alternativaDao;
    }

    public void setAlternativaDao(AlternativaDao alternativaDao) {
        this.alternativaDao = alternativaDao;
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public DataModel<Alternativa> getModelAlternativas() {
        return modelAlternativas;
    }

    public void setModelAlternativas(DataModel<Alternativa> modelAlternativas) {
        this.modelAlternativas = modelAlternativas;
    }

    public Alternativa getAlter() {
        return alter;
    }

    public void setAlter(Alternativa alter) {
        this.alter = alter;
    }

    public Pergunta getPergunta() {
        
        if (pergunta == null) {
            pergunta = new Pergunta();
        }
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }    

}
