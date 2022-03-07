package br.com.quiz.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

/**
*
* @author alf_a
*/
public class EnviaEmail {
	
	private static final String EMAIL_REMETENTE = "";
	private static final String EMAIL_SENHA_REMETENTE = "";
	private static final String EMAIL_SERVIDOR_GMAIL = "smtp.gmail.com";
	private static final int EMAIL_PORTA_GMAIL = 465;

	
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
	public static boolean enviaEmail(String[] destinatarios, String titulo, String texto)
			throws IOException, URISyntaxException {
		
		String temp = "Teste de envio deu certo!";
		SimpleEmail email = new SimpleEmail();
		boolean envioFinalizado = true;
		email.setHostName(EMAIL_SERVIDOR_GMAIL);
		email.setSmtpPort(EMAIL_PORTA_GMAIL);
		email.setAuthenticator(new DefaultAuthenticator(EMAIL_REMETENTE, EMAIL_SENHA_REMETENTE));

		try {
			System.out.println("Enviando email...");
			email.setFrom(EMAIL_REMETENTE);
			email.setSubject(titulo);
			email.setMsg(temp);
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


		

	


