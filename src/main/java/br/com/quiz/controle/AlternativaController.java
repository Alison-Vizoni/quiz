package br.com.quiz.controle;

import br.com.quiz.model.dao.AlternativaDao;
import br.com.quiz.model.dao.AlternativaDaoImpl;
import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.entidade.Alternativa;
import br.com.quiz.model.entidade.Categoria;
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

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "alternativaC")
@ViewScoped
public class AlternativaController implements Serializable {

    private List<Alternativa> listaAlternativas = new ArrayList<>();
    private DataModel<Alternativa> modelAlternativas;
    private AlternativaDao alternativaDao;
    private Alternativa alternativa;
    private Session sessao;

    private Long contadorId = 0L;
    private Alternativa alter;
    private Categoria categoria;
    private CategoriaDao categoriaDao;

    public AlternativaController() {
        alternativaDao = new AlternativaDaoImpl();

    }

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

    // CRUD
    
    
    
    
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

    public Categoria getCategoria() {
        if (categoria == null) {
            categoria = new Categoria();
        }
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDao getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    

}
