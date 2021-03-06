package br.com.quiz.controle;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
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

import br.com.quiz.model.dao.HibernateUtil;
import br.com.quiz.service.EnviaEmail;
import br.com.quiz.util.Utils;

/**
 *
 * @author alf_a
 */
@ManagedBean(name = "emailC")
@ViewScoped
public class EmailConvidadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.logger(getClass());

	private static List<String> listaEmailConvidado;
	private DataModel<String> modelEmails;
	private String emailConvidado;

	private String sucesso = "";

	private Session sessao;

	public EmailConvidadoController() {
		if (listaEmailConvidado == null) {
			listaEmailConvidado = new ArrayList<>();
		}
	}

	/**
	 * Adiciona emails na lista de remessa
	 */
	
	public void salvarListaEmails() {
		logger.info("método - salvarListaEmails()");
		
		if (listaEmailConvidado.contains(emailConvidado)) {
			Mensagem.erro("Email já adicionado!");
		} else if (Utils.stringValida(emailConvidado)) {
			listaEmailConvidado.add(emailConvidado);
			modelEmails = new ListDataModel<>(listaEmailConvidado);
			emailConvidado = null;
		} else {
			Mensagem.erro("Não há email para incluir!");
		}
	}

	public void enviaEmail() {
		logger.info("método - enviaEmail()");

		try {
			sessao = HibernateUtil.abrirSessao();
			String[] emails = listaEmailConvidado.toArray(new String[0]);
			verificaListaEmail(emails);
		} catch (HibernateException | IOException | URISyntaxException e) {
			Mensagem.erro("Falha no envio !");
			logger.error("Erro ao enviaEmail - " + e.getMessage());
		} finally {
			sessao.close();
		}
	}

	/**
	 * Confere se a lista de emails não está vazia
	 * 
	 * @param emails
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private void verificaListaEmail(String[] emails) throws IOException, URISyntaxException {
		if (emails.length > 0) {
			EnviaEmail.enviaEmail(emails, QuizController.idAplicacaoQuiz, LoginController.usuarioSessao().getNome());
			Mensagem.sucesso("Envio finalizado!");
			sucesso = String.valueOf(QuizController.idAplicacaoQuiz);
			modelEmails = null;
			listaEmailConvidado = null;
			emailConvidado = null;

		} else {
			Mensagem.erro("Ops, parece que você esqueceu de adicionar os emails!");
		}
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

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

}
