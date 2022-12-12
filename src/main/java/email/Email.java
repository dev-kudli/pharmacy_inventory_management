package email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public abstract class Email {
    
    public static boolean sendMail() {
        System.out.println("Preparing Mail ");
        try{
            Properties prop =new Properties();
            prop.put("mail.smtp.auth","true");
            prop.put("mail.smtp.starttls.enable","true");
            prop.put("mail.smtp.host","smtp.gmail.com");
            prop.put("mail.smtp.port","587");

            String fromEmail="aedbnkadmn@gmail.com";
            String password = "iifymizvftfdvxox";

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail,password); 
                }    
            });

            Message message = prepareMessage(session,fromEmail);
            Transport.send(message);
            System.out.println("Mail sent successfully");
            return true;
        } catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    private static Message prepareMessage(Session session,String fromEmail){
        try {
            Message msg =new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("sudarshan97.kudli@gmail.com"));
           
            msg.setSubject("Healcare Management");
            msg.setText("Thank you for Registering, Welcome to our Healthcare Management Services");
            return msg;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}