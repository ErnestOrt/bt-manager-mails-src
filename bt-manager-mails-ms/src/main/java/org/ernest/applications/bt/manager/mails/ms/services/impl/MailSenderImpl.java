package org.ernest.applications.bt.manager.mails.ms.services.impl;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.ernest.applications.bt.manager.mails.ct.exceptions.SendMailException;
import org.ernest.applications.bt.manager.mails.ms.services.MailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderImpl implements MailSender{

	private static final String BIKE_TEAM_OFICIAL = "writerlanddonotreplay@gmail.com";
	
	@Override
	public void send(String title, String body, String to) throws SendMailException {
		try{
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
	
			Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(BIKE_TEAM_OFICIAL, "manolocabezabolo");
					}
				});


			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(BIKE_TEAM_OFICIAL));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(title);
	
			Multipart multipart = new MimeMultipart();
			BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body, "text/html; charset=utf-8");
			multipart.addBodyPart(htmlPart);

			message.setContent(multipart);

			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			throw new SendMailException(e.getMessage());
		}
	}
}
