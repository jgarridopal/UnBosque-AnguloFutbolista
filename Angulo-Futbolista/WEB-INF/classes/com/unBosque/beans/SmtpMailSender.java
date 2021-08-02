package com.unBosque.beans;

import java.io.Serializable;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("mailSender")
public class SmtpMailSender implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7852511547562019606L;
	private static Pattern pattern;
	private static Matcher matcher;
	
	@Autowired
	private JavaMailSender javaMailSender;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public void enviarCorreo(String toEmail, String subject, String text) throws Exception {
		
		if(!validate(toEmail))
			throw new Exception("Dirección no valida");
	    
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
        helper.setTo(toEmail); 
        helper.setSubject(subject); 
        helper.setText(text);
        
        try {
        	javaMailSender.send(message);
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new Exception("Error enviando el correo");
        }
		
	}
	
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validate(final String hex) {

		pattern = Pattern.compile(EMAIL_PATTERN);
		
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("angulofutbolista@gmail.com");
	    mailSender.setPassword("21654efxsdf");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	     
	    return mailSender;
	}
	
}
