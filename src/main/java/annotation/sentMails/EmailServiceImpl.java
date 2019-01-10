package annotation.sentMails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
 
@Component
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	public JavaMailSender emailSender;
	
	public void sendSimpleMessage(String text) {
		
		SimpleMailMessage message = new SimpleMailMessage();

		message.setSubject("test mail");
		message.setText(text);
		emailSender.send(message);
	}

}
