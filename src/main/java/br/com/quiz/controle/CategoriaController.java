package br.com.quiz.controle;

import br.com.quiz.model.dao.CategoriaDao;
import br.com.quiz.model.dao.CategoriaDaoImpl;
import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.entidade.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "categoriaC")
@ViewScoped
public class CategoriaController {

    private Categoria categoria;
    private CategoriaDao categoriaDao;
    private Session sessao;
    
    private List<Categoria> categorias;
    private List<SelectItem> comboCategorias;

    public CategoriaController() {
        categoriaDao = new CategoriaDaoImpl();
        populaComboCategorias();
    }
    
    // CRUD
    
    /**
     * Popula o comboBox ao entrar no subItem 'categoria'
     * 
     * @return lista com todas categorias cadastradas no BD
     */
    public List<SelectItem> populaComboCategorias(){
        try {
            sessao = HibernateUtil.abrirSessao();
            categorias = categoriaDao.populaComboInicial(sessao);
            comboCategorias = new ArrayList<>();
            
            categorias.forEach(cat -> {
                comboCategorias.add(new SelectItem(cat.getId(), cat.getNome()));
            });            
            
        } catch (HibernateException e) {
            System.err.println("método - populaComboCategorias(); \n Erro ao popular combo categorias [" + e.getMessage() + "]");
        } finally {
            sessao.close();
        }        
        return comboCategorias;        
    }
    
    // GETTERS AND SETTERS

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

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<SelectItem> getComboCategorias() {
        return comboCategorias;
    }

    public void setComboCategorias(List<SelectItem> comboCategorias) {
        this.comboCategorias = comboCategorias;
    }    

}
