/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.quiz.util;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Silvio
 */
public class EmailTeste {

    private Session session;
    private static final Dotenv dotenv = Dotenv.configure().load();
    private static final String EMAIL = "gabreilfake@gmail.com";

    private void criarSessaoEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, dotenv.get("PASSWORD"));
            }
        });
        session.setDebug(true);
    }

//    public boolean criarEmailUsuarioNovo(Usuario usuario) {
//        boolean enviou = false;
//        criarSessaoEmail();
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(EMAIL));
//            //Destinatário(s)
//            Address[] toUser = InternetAddress.parse(usuario.getLogin());
//            message.setRecipients(Message.RecipientType.TO, toUser);
//            message.setSubject("Dados de acesso ao ssitema XYZ Ltda.");
//            //Assunto
//            StringBuilder email = new StringBuilder();
//            email.append("Olá ").append(usuario.getNome()).append("!");
//            email.append("\n\n\n");
//            email.append("Segue os dados de acesso do sistema XYZ Ltda!");
//            email.append("\n");
//            email.append("Seu login é seu e-mail ").append(usuario.getLogin());
//            email.append("\n");
//            email.append("Sua é ").append(usuario.getSenha());
//            email.append("\n\n\n");
//            email.append("Atenciosamente RH Empresa XYZ Ltda");
//
//            message.setText(email.toString());
//
//            Transport.send(message); //  Método para enviar a mensagem criada
//            System.out.println("Feito!!!");
//            enviou = true;
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//        return enviou;
//    }
}
