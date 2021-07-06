package com.controller.validacionesprimefaces;

import java.io.Serializable;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

public class mailsender implements Serializable{
	
   public boolean sendMail(String toMail,String subject,String message) throws AddressException, MessagingException {
	   /*  datos email y contrasena*/
	   final String username1="diegbv96@gmail.com";
	   final String password1= "42663232548988";
	   
	   /* parametros que permiten acceder al correo email,el puert y permisos*/
	   Properties props=System.getProperties();
	   props.put("mail.smtp.host","smtp.gmail.com");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.port", "465");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.socketFactory.port", "465");
	   props.put("mail.smtp.socketFactory.fallback", "false");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   
	   /* aqui se obtiene el username1 y password1 automaticamente */
	   Session mailSession=Session.getInstance(props,
			   new Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
       		return new PasswordAuthentication(username1, password1);
       	}
	   });
	   try {
		   /* el bodypart es para obtener una imagen */
		   BodyPart imagen= new MimeBodyPart();
		   MimeMultipart partes = new MimeMultipart();
		  
             /*aqui obtenemos la direccion en donde se encuentra nuetra pc en donde se encuentra la imagen  */
		   //String contextDir =  (getClass().getResource("\\imagenes\\correo.png"))+"";
		   System.out.println("rutaa ---> " + System.getProperty("user.dir")+"/imagenes/imag/correo.png");
		   imagen.setDataHandler(new DataHandler(new FileDataSource(System.getProperty("user.dir")+"/imagenes/imag/correo.png")));
		   partes.addBodyPart(imagen);
		   /*aqui empezamos con la sesion de email donde se declara el correo que envia(fromMail), el correo destino 
		    * (tomail), el mensaje(message), la imagen (partes), y el asunto(subject)*/
		   Message mailMessage=new MimeMessage(mailSession);
		   mailMessage.setFrom(new InternetAddress("diegbv96@gmail.com"));
		   mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		   mailMessage.setContent(message,"text/html");
		   mailMessage.setContent(partes);
		   mailMessage.setSubject(subject);
	
		   /*Aqui nos conectamos al servicio de gmail, añadiendo el username1 y password1 declarados arriba y enviamos el mensaje*/
		  Transport transport=mailSession.getTransport("smtp");
		  transport.connect("smtp.gmail.com", username1, password1);
		  transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		  return true;
	   }catch(MessagingException ex) {
		   return false;
		   //throw new RuntimeException(ex);
		  
	   }
	   
	   
	   
   }
}