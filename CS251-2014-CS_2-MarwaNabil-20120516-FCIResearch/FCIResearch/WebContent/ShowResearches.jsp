<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FCI Research - Researches</title>
<link rel="stylesheet" href="css/ResearchPage.css" type="text/css"/>
</head>
<body>

<%@ page import="dao.*" %>
<%@ page import="entities.*" %>

    
<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>
<div class="cont">         

<div class="Form">
    
    
<form method ="post" action = "RequestAccessResearch" >
 
   <%	
   ResearchDAO rD=new ResearchDAO();
   Research[] arr=rD.getResearches();
	for(int i=0;;++i){
		try{
			out.println("Research Title: "+arr[i].getTitle());
			out.println("-Owner ID: "+arr[i].getownerID());
			int ID = (int)session.getAttribute("ID");
%>
<br>
<%			
			if (arr[i].getownerID() != ID)
			{
				
			
			
%>
<input type="radio" name="ResearchName" value="<%=arr[i].getTitle()%>"> Send Request for <%=arr[i].getTitle()%> <br>
<input type="hidden" name = "<%=arr[i].getTitle()%>" value="<%=arr[i].getownerID()%>">
<br>
<%	
			}
			}
		catch(Exception e){
			break;
		}

	}
%>
<br>  
<input type="submit"  id="Button" value="Send request" /> <br>         
 </form>      
   
</div>
    
     <div class="space">                </div>

<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
    </div>
        


</body>
</html>