<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FCI Research -Sending mail</title>
<link rel="stylesheet" href="css/basic.css" type="text/css"/>

</head>
<body>

<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>
<div class="cont">         

    
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%@ page import="javax.activation.*"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*"%>

<%
	String result="";
	final String username = "fciresearchwebsite@gmail.com";
	final String password = "fciresearch1234";
	
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	
	Session Msession = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });
	
	try {
	
		Message message = new MimeMessage(Msession);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(session.getAttribute("receiver").toString()));
		message.setSubject("New Notification From FCIResearch!");
		message.setText(session.getAttribute("message").toString());
	
		Transport.send(message);
	
		result="E-mail sent successfully";
	
	} catch (MessagingException e) {
		System.out.println(e.getLocalizedMessage());
		result="Couldn't send email";
		throw new RuntimeException(e);
	}
%>

<center>
<h1><%=result %></h1>
</center>
    </div>
    
     <div class="space">                </div>

</body>
</html>