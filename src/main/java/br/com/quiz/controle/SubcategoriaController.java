package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.model.dao.SubCategoriaDao;
import br.com.quiz.model.dao.SubCategoriaDaoImpl;
import br.com.quiz.model.entidade.Categoria;
import br.com.quiz.model.entidade.SubCategoria;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "subcategoriaC")
@ViewScoped
public class SubcategoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.logger(getClass());

	private List<SelectItem> comboSubcategorias;
	private List<SubCategoria> subcategorias;
	private SubCategoriaDao subCategoriaDao;
	private SubCategoria subCategoria;
	private Categoria categoria;
	private Session sessao;

	public SubcategoriaController() {
		logger.info("entrou na SubcategoriaController");
		subCategoriaDao = new SubCategoriaDaoImpl();		
	}

	/**
	 * Popula o comboBox ao entrar no subItem 'categoria'
	 */
	public void populaComboSubCategorias(Categoria categoria) {
		logger.info("método populaComboSubCategorias");
		try {
			sessao = HibernateUtil.abrirSessao();
			subcategorias = subCategoriaDao.buscaPorCategoria(categoria, sessao);
			comboSubcategorias = new ArrayList<>();

			subcategorias.forEach(cat -> {
				comboSubcategorias.add(new SelectItem(cat.getId(), cat.getNome().toUpperCase()));
			});

		} catch (HibernateException e) {
			logger.error("método - populaComboSubCategorias(); \n Erro ao popular combo [" + e.getMessage() + "]");
		} finally {
			sessao.close();
		}
	}

	// GETTERS AND SETTERS
		

	public SubCategoria getSubCategoria() {		
		if (null == subCategoria) {
			subCategoria = new SubCategoria();
		}
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	
	public List<SelectItem> getComboSubcategorias() {
		return comboSubcategorias;
	}

	public void setComboSubcategorias(List<SelectItem> comboSubcategorias) {
		this.comboSubcategorias = comboSubcategorias;
	}

	public List<SubCategoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<SubCategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public SubCategoriaDao getSubCategoriaDao() {
		return subCategoriaDao;
	}

	public void setSubCategoriaDao(SubCategoriaDao subCategoriaDao) {
		this.subCategoriaDao = subCategoriaDao;
	}

	public Categoria getCategoria() {
		if (null == categoria) {
			categoria = new Categoria();
		}
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}
