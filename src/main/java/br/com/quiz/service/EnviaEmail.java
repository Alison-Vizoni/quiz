package br.com.quiz.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

/**
*
* @author alf_a
*/
public class EnviaEmail {
	
	private static String nomeUsuario;
	private static Long codQuiz;
	
	private static final String EMAIL_REMETENTE = "usoparatestes2@gmail.com";
	private static final String EMAIL_SENHA_REMETENTE = "ftfz uvaf iisv vawm";
	
	private static final String EMAIL_SERVIDOR_GMAIL = "smtp.gmail.com";
	private static final int EMAIL_PORTA_GMAIL = 587;
	
		
	/**
	 * Realiza envio de email
	 * 
	 * @param destinatarios - emails que receberao o envio
	 * @param titulo - titulo do email
	 * @param texto - corpo do email
	 * @return - status booleano do envio
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static boolean enviaEmail(String[] destinatarios, Long idAplicacaoQuiz, String usuario)
			throws IOException, URISyntaxException {
		
		nomeUsuario = usuario;
		codQuiz = idAplicacaoQuiz;
		
		String BODY_EMAIL = TemplateSimples.montaTemplate(nomeUsuario, codQuiz);
		String TITLE_EMAIL = nomeUsuario + " está esperando suas respostas";
		
		
		HtmlEmail email = new HtmlEmail();
		boolean envioFinalizado = true;
		email.setHostName(EMAIL_SERVIDOR_GMAIL);
		email.setSmtpPort(EMAIL_PORTA_GMAIL);
		email.setAuthenticator(new DefaultAuthenticator(EMAIL_REMETENTE, EMAIL_SENHA_REMETENTE));

		try {
			System.out.println("Enviando email...");
			email.setFrom(EMAIL_REMETENTE);
			email.setSubject(TITLE_EMAIL);
			email.setMsg(BODY_EMAIL);
			email.addTo(destinatarios);
			email.setSSLOnConnect(true);
			email.setSSLCheckServerIdentity(true);
			email.send();
			System.out.println("Email enviado com sucesso!");

		} catch (Exception e) {
			System.err.println(e.getMessage());
			envioFinalizado = false;
		}
		return envioFinalizado;
	}
	
}


		

	


