package br.com.quiz.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

/**
*
* @author alf_a
*/
@ManagedBean(name = "emailC")
@ViewScoped
public class EmailConvidadoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.logger(getClass());
	
	private DataModel<String> modelEmails;
	private List<String> listaEmailConvidado;
	private String emailConvidado;
	
	public EmailConvidadoController() {
		if (listaEmailConvidado == null) {
			listaEmailConvidado = new ArrayList<>();
		}
		
	}
	
	public void salvarListaEmails() {
		listaEmailConvidado.add(emailConvidado);
		modelEmails = new ListDataModel<>(listaEmailConvidado);
		emailConvidado = null;		
		
		logger.info(listaEmailConvidado.size());
		
	}

	public List<String> getListaEmailConvidado() {
		return listaEmailConvidado;
	}

	public void setListaEmailConvidado(List<String> listaEmailConvidado) {
		this.listaEmailConvidado = listaEmailConvidado;
	}

	public DataModel<String> getModelEmails() {
		return modelEmails;
	}

	public void setModelEmails(DataModel<String> modelEmails) {
		this.modelEmails = modelEmails;
	}

	public String getEmailConvidado() {
		return emailConvidado;
	}

	public void setEmailConvidado(String emailConvidado) {
		this.emailConvidado = emailConvidado;
	}
	
}
