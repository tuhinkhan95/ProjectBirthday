package com.tklearning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tklearning.model.Friends;

public class MailCheck {


	public  List<Friends> mailSenders (List<Friends> friendsMail) {
		//	List<Friends> sendMail=new ArrayList<Friends>();
		// TODO Auto-generated method stub
		String to=null;
		final String username = "khan.tuhin.420@gmail.com";
		final String password = "JangliJawani*21";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			for(Friends friend:friendsMail) {
				to = friend.getEmail();
				message.setRecipients(
						Message.RecipientType.TO,


						InternetAddress.parse(to)


						);
			}
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Mail Sender ,"
					+ "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return friendsMail;
	}



}


