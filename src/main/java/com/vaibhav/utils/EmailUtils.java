package com.vaibhav.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmailUtils {

	
	@Autowired
	private JavaMailSender mailSender;

//	@Bean
//    public JavaMailSenderImpl mailSender() {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost("smtp.gmail.com");
//        javaMailSender.setPort(25);
//        
//       
//        return javaMailSender;
//    }
	
	public boolean sendEmail(String to, String subject, String body) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		boolean isSent = false;
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			mailSender.send(helper.getMimeMessage());
			isSent = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return isSent;
	}
}
