<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FCI Research - Notification Page</title>
<link rel="stylesheet" href="css/NotificationPage.css" type="text/css"/>

</head>
    
<body>
    
<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>

<div class="cont">         


<%@ page import="dao.*" %>
<%@ page import="entities.*" %>
<h1>Notification Page </h1>

<div class="Form">    

   <%	
 	NotificationDAO nD=new NotificationDAO();
    int ID = (int)session.getAttribute("ID");
    
    Notification[] arr=nD.getNotification(ID);
	for(int i=0;;++i){
		try{
			out.println(arr[i].getMsg());
			if (arr[i].getType() == 2)
			{
				
			
			
%>
       <br>
 <form method ="post" action = "AcceptReject" >
<input type="radio" name="Acc/Rej" value="Accept"> Will send Mail <br>
<input type="radio" name="Acc/Rej" value="Reject"> Reject <br>
<input type="hidden" name = "oldSource" value=<%= arr[i].getNotificationSenderID() %> >
<input type="submit" class="Button" value="Send reply" /> <br>         
 </form> 
<br>
		<%	

		}
		else
		{
			%>
<br>
<br>			
<%
		}
		}
		catch(Exception e){
			break;
		}

	}
%>    
    </div>
<div class="space">                </div>
            </div>
    
<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
       </div>
    
</body>
</html>