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
	
	private static final String EMAIL_REMETENTE = "";
	private static final String EMAIL_SENHA_REMETENTE_1 = "";
	private static final String EMAIL_SENHA_REMETENTE = "";
	
	private static final String EMAIL_SERVIDOR_GMAIL = "smtp.gmail.com";
	private static final int EMAIL_PORTA_GMAIL = 587;
	
	private static final String BODY_EMAIL = "<a href='http://localhost:8080/quiz'> Responder </a>";
	
//	private static final String BODY_EMAIL = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
//			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">"			
//			+ "<head>\r\n"
//			+ "    <meta charset=\"UTF-8\">\r\n"
//			+ "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\r\n"
//			+ "    <meta name=\"x-apple-disable-message-reformatting\">\r\n"
//			+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
//			+ "    <meta content=\"telephone=no\" name=\"format-detection\">\r\n"
//			+ "    <title></title>\r\n"
//			+ "    <!--[if (mso 16)]>\r\n"
//			+ "    <style type=\"text/css\">\r\n"
//			+ "    a {text-decoration: none;}\r\n"
//			+ "    </style>\r\n"
//			+ "    <![endif]-->\r\n"
//			+ "    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\r\n"
//			+ "    <!--[if gte mso 9]>\r\n"
//			+ "<xml>\r\n"
//			+ "    <o:OfficeDocumentSettings>\r\n"
//			+ "    <o:AllowPNG></o:AllowPNG>\r\n"
//			+ "    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
//			+ "    </o:OfficeDocumentSettings>\r\n"
//			+ "</xml>\r\n"
//			+ "<![endif]-->\r\n"
//			+ "</head>\r\n"
//			+ "\r\n"
//			+ "<body>\r\n"
//			+ "    <div class=\"es-wrapper-color\">\r\n"
//			+ "        <!--[if gte mso 9]>\r\n"
//			+ "			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n"
//			+ "				<v:fill type=\"tile\" color=\"#f8f9fd\"></v:fill>\r\n"
//			+ "			</v:background>\r\n"
//			+ "		<![endif]-->\r\n"
//			+ "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
//			+ "            <tbody>\r\n"
//			+ "                <tr>\r\n"
//			+ "                    <td class=\"esd-email-paddings\" valign=\"top\">\r\n"
//			+ "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-header-popover\" align=\"center\">\r\n"
//			+ "                            <tbody>\r\n"
//			+ "                                <tr>\r\n"
//			+ "                                    <td class=\"esd-stripe\" align=\"center\" bgcolor=\"#f8f9fd\" style=\"background-color: #f8f9fd;\">\r\n"
//			+ "                                        <table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"background-color: transparent;\">\r\n"
//			+ "                                            <tbody>\r\n"
//			+ "                                                <tr>\r\n"
//			+ "                                                    <td class=\"esd-structure es-p20t es-p10b es-p20r es-p20l\" align=\"left\">\r\n"
//			+ "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                            <tbody>\r\n"
//			+ "                                                                <tr>\r\n"
//			+ "                                                                    <td width=\"560\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n"
//			+ "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                                            <tbody>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10b\">\r\n"
//			+ "                                                                                        <h1>Bem-vindo ao template de demonstração de Stripo!</h1>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10t es-p10b\">\r\n"
//			+ "                                                                                        <p>Use os editores de e-mail HTML de arrastar e soltar:</p>\r\n"
//			+ "                                                                                        <p>dois construtores em um.</p>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                            </tbody>\r\n"
//			+ "                                                                        </table>\r\n"
//			+ "                                                                    </td>\r\n"
//			+ "                                                                </tr>\r\n"
//			+ "                                                            </tbody>\r\n"
//			+ "                                                        </table>\r\n"
//			+ "                                                    </td>\r\n"
//			+ "                                                </tr>\r\n"
//			+ "                                                <tr>\r\n"
//			+ "                                                    <td class=\"esd-structure es-p15t es-m-p15t es-m-p0b es-m-p0r es-m-p0l\" align=\"left\">\r\n"
//			+ "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                            <tbody>\r\n"
//			+ "                                                                <tr>\r\n"
//			+ "                                                                    <td width=\"600\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n"
//			+ "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                                            <tbody>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\r\n"
//			+ "                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://hpy.stripocdn.email/content/guids/CABINET_1ce849b9d6fc2f13978e163ad3c663df/images/3991592481152831.png\" alt style=\"display: block;\" width=\"600\"></a>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                            </tbody>\r\n"
//			+ "                                                                        </table>\r\n"
//			+ "                                                                    </td>\r\n"
//			+ "                                                                </tr>\r\n"
//			+ "                                                            </tbody>\r\n"
//			+ "                                                        </table>\r\n"
//			+ "                                                    </td>\r\n"
//			+ "                                                </tr>\r\n"
//			+ "                                            </tbody>\r\n"
//			+ "                                        </table>\r\n"
//			+ "                                    </td>\r\n"
//			+ "                                </tr>\r\n"
//			+ "                            </tbody>\r\n"
//			+ "                        </table>\r\n"
//			+ "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\">\r\n"
//			+ "                            <tbody>\r\n"
//			+ "                                <tr>\r\n"
//			+ "                                    <td class=\"esd-stripe\" align=\"center\" bgcolor=\"#071f4f\" style=\"background-color: #071f4f; background-image: url(https://hpy.stripocdn.email/content/guids/CABINET_1ce849b9d6fc2f13978e163ad3c663df/images/10801592857268437.png); background-repeat: no-repeat; background-position: center top;\" background=\"https://hpy.stripocdn.email/content/guids/CABINET_1ce849b9d6fc2f13978e163ad3c663df/images/10801592857268437.png\">\r\n"
//			+ "                                        <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n"
//			+ "                                            <tbody>\r\n"
//			+ "                                                <tr>\r\n"
//			+ "                                                    <td class=\"esd-structure es-p40t es-p40b es-p30r es-p30l\" align=\"left\">\r\n"
//			+ "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                            <tbody>\r\n"
//			+ "                                                                <tr>\r\n"
//			+ "                                                                    <td width=\"540\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n"
//			+ "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                                            <tbody>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"center\" class=\"esd-block-spacer\" height=\"20\"></td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"left\" class=\"esd-block-text es-p10b\">\r\n"
//			+ "                                                                                        <h1 style=\"text-align: center; color: #ffffff;\"><b>Faixas — Vá além das margens</b></h1>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10t es-p10b\">\r\n"
//			+ "                                                                                        <p style=\"color: #ffffff;\">Se você precisa criar um plano de fundo para o e-mail, expandir um banner ou destacar o conteúdo, basta definir a cor da faixa.</p>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                            </tbody>\r\n"
//			+ "                                                                        </table>\r\n"
//			+ "                                                                    </td>\r\n"
//			+ "                                                                </tr>\r\n"
//			+ "                                                            </tbody>\r\n"
//			+ "                                                        </table>\r\n"
//			+ "                                                    </td>\r\n"
//			+ "                                                </tr>\r\n"
//			+ "                                            </tbody>\r\n"
//			+ "                                        </table>\r\n"
//			+ "                                    </td>\r\n"
//			+ "                                </tr>\r\n"
//			+ "                            </tbody>\r\n"
//			+ "                        </table>\r\n"
//			+ "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-footer-popover\" align=\"center\">\r\n"
//			+ "                            <tbody>\r\n"
//			+ "                                <tr>\r\n"
//			+ "                                    <td class=\"esd-stripe\" align=\"center\" bgcolor=\"#f8f9fd\" style=\"background-color: #f8f9fd; background-image: url(https://hpy.stripocdn.email/content/guids/CABINET_1ce849b9d6fc2f13978e163ad3c663df/images/83191592482092483.png); background-repeat: no-repeat; background-position: center center;\" background=\"https://hpy.stripocdn.email/content/guids/CABINET_1ce849b9d6fc2f13978e163ad3c663df/images/83191592482092483.png\">\r\n"
//			+ "                                        <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n"
//			+ "                                            <tbody>\r\n"
//			+ "                                                <tr>\r\n"
//			+ "                                                    <td class=\"esd-structure es-p40t es-p15b es-p20r es-p20l\" align=\"left\">\r\n"
//			+ "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                            <tbody>\r\n"
//			+ "                                                                <tr>\r\n"
//			+ "                                                                    <td width=\"281\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n"
//			+ "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                                            <tbody>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"left\" class=\"esd-block-text\">\r\n"
//			+ "                                                                                        <h1 style=\"text-align: center;\"><b>Estrutura — Crie a base de seu e-mail</b></h1>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                            </tbody>\r\n"
//			+ "                                                                        </table>\r\n"
//			+ "                                                                    </td>\r\n"
//			+ "                                                                </tr>\r\n"
//			+ "                                                            </tbody>\r\n"
//			+ "                                                        </table>\r\n"
//			+ "                                                    </td>\r\n"
//			+ "                                                </tr>\r\n"
//			+ "                                                <tr>\r\n"
//			+ "                                                    <td class=\"esd-structure es-p15t es-p20b es-m-p15t es-m-p20b es-m-p15r es-m-p15l\" align=\"left\">\r\n"
//			+ "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                            <tbody>\r\n"
//			+ "                                                                <tr>\r\n"
//			+ "                                                                    <td width=\"600\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n"
//			+ "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n"
//			+ "                                                                            <tbody>\r\n"
//			+ "                                                                                <tr>\r\n"
//			+ "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\r\n"
//			+ "                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://hpy.stripocdn.email/content/guids/CABINET_1ce849b9d6fc2f13978e163ad3c663df/images/69701592901570150.gif\" alt style=\"display: block;\" width=\"600\"></a>\r\n"
//			+ "                                                                                    </td>\r\n"
//			+ "                                                                                </tr>\r\n"
//			+ "                                                                            </tbody>\r\n"
//			+ "                                                                        </table>\r\n"
//			+ "                                                                    </td>\r\n"
//			+ "                                                                </tr>\r\n"
//			+ "                                                            </tbody>\r\n"
//			+ "                                                        </table>\r\n"
//			+ "                                                    </td>\r\n"
//			+ "                                                </tr>\r\n"
//			+ "                                            </tbody>\r\n"
//			+ "                                        </table>\r\n"
//			+ "                                    </td>\r\n"
//			+ "                                </tr>\r\n"
//			+ "                            </tbody>\r\n"
//			+ "                        </table>\r\n"
//			+ "                    </td>\r\n"
//			+ "                </tr>\r\n"
//			+ "            </tbody>\r\n"
//			+ "        </table>\r\n"
//			+ "    </div>\r\n"
//			+ "</body>\r\n"
//			+ "\r\n"
//			+ "</html>";
	
//	private static final String BODY_EMAIL = "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"
//			+ "     <tr>"
//			+ "      <td>"
//			+ "       <h1>http://localhost:8080/quiz/login.xhtml</h1>"
//			+ "      </td>"
//			+ "     </tr>"
//			+ "    </table>";

	
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
		
		HtmlEmail email = new HtmlEmail();
		boolean envioFinalizado = true;
		email.setHostName(EMAIL_SERVIDOR_GMAIL);
		email.setSmtpPort(EMAIL_PORTA_GMAIL);
		email.setAuthenticator(new DefaultAuthenticator(EMAIL_REMETENTE, EMAIL_SENHA_REMETENTE));
		//email.setContent(BODY_EMAIL, HtmlEmail.TEXT_HTML);

		try {
			System.out.println("Enviando email...");
			email.setFrom(EMAIL_REMETENTE);
			email.setSubject(titulo);
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


		

	


