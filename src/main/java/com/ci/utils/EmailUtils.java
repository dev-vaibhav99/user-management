package com.ci.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmailUtils {

	
	@Autowired
	private JavaMailSender mailSender;

    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        return javaMailSender;
    }
	
	public boolean sendEmail(String to, String subject, String body) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		boolean isSent = false;
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			mailSender.send(helper.getMimeMessage());
			isSent = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return isSent;
	}
}
