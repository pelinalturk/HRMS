package kodlamaio.Hrms.core.utilities.validation.concretes;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

//@Controller
public class EmailValidationManager {

//	 @Autowired
//	    private JavaMailSender mailSender;
//
//	    public String sendMail() {
//	        MimeMessage mimeMessage = mailSender.createMimeMessage();
//	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//
//	        try {
//	            messageHelper.setTo("emailadress");
//	            messageHelper.setText("içerik:)");
//	            messageHelper.setSubject("Konu");
//	        } catch (MessagingException e) {
//	            e.printStackTrace();
//	            return "Error...";
//	        }
//	        mailSender.send(mimeMessage);
//	        return "Mail Sent!";
//	    }
}
