// import java.util.*;
// import javax.mail.*;
// import javax.mail.internet.*;
// import javax.activation.*;

// /**
//  * 
//  * This will be used to send bug/error reports directly to an email address. You must
//  * change USERNAME and PASSWORD fields below to your gmail password to get it to work. 
//  * If it still is not working, or the import messages above are in red, that means you
//  * need to import the jar files related to this class
//  *
//  */

// public class SendEmail {

// private static String SMPT_HOSTNAME = "587";
// private static String USERNAME = "araza617@gmail.com";
// private static String PASSWORD = "Hellodude12$";

// public SendEmail() {}

// public static void sendEmailMethod(String bugText, String emailText) {
//     Properties props = new Properties();
//     props.put("mail.smtp.host", "smtp.gmail.com");
//     props.put("mail.from", emailText);
//     props.put("mail.smtp.starttls.enable", "true");
//     props.put("mail.smtp.auth", "true");
//     props.put("mail.debug", "true");

//     Session session = Session.getInstance(props, new Authenticator() {
//         @Override
//         protected PasswordAuthentication getPasswordAuthentication() {
//             return new PasswordAuthentication(USERNAME, PASSWORD);
//         }
//     });
//     try {
//         MimeMessage msg = new MimeMessage(session);
//         msg.setFrom();
//         msg.setRecipients(Message.RecipientType.TO,
//                           "araza617@gmail.com");
//         msg.setSubject("RPG Game Error / Bug / Feedback");
//         msg.setSentDate(new Date());
//         msg.setText(bugText);
//         Transport.send(msg);
//      } catch (MessagingException mex) {
//         System.out.println("send failed, exception: " + mex);
//      }
//     }
// }