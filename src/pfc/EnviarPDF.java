/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfc;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Balbicosta
 */
public class EnviarPDF {
    
    // Método para envio do relatório de saúde para email do funcionário.
    public void enviarPDF(String email, String cam, String nome) throws AddressException, MessagingException, EmailException{
        
        Properties prop = new Properties();
        // Definição das propriedades de conexão com  servidor de email.
        prop.put("mail.smtp.host", "smtp-mail.outlook.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.socketFactory.port", 587);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.fallback", "true");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.debug", "true");
        
        // Autenticação da senha do email do remetente.
        Session sec = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
           {
                 return new PasswordAuthentication("balbicosta@outlook.com",
                 "");
           }
        });
        
        sec.setDebug(true);
            // Instância do objeto de mensagem e definição dos parâmetros do REMETENTE e corpo da mensagem.
            Message msn = new MimeMessage(sec);
            msn.setFrom(new InternetAddress("balbicosta@outlook.com"));
            msn.setSubject("Resultado Atestado de Saúde Ocupacional");
            msn.setText("Segue em anexo o resultado do seu ASO.");
            
            // Definição do endereço do DESTINATÁRIO
            Address[] toUser = InternetAddress.parse(email);
            msn.setRecipients(Message.RecipientType.TO, toUser);
            
            //Instâncias para inclusão de ANEXO no corpo da mensagem.
            MimeBodyPart mbp = new MimeBodyPart();
            Multipart mpt = new MimeMultipart();
            DataSource source = new FileDataSource(cam);
            mbp.setDataHandler(new DataHandler(source));
            mbp.setFileName(nome);
            mpt.addBodyPart(mbp);
            msn.setContent(mpt);
            Transport.send(msn);
    }
}
