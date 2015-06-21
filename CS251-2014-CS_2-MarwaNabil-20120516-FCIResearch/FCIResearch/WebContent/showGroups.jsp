<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FCI Research - Show Groups</title>    
<link rel="stylesheet" href="css/postResearchPage.css" type="text/css"/>
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

<%	
 	GroupDao gD=new GroupDao();
	Group[] arr=gD.getGroups();
	for(int i=0;;++i){
		try{
			out.println("Group ID: "+arr[i].name);
			out.println("Group Name: "+arr[i].name);
			out.println("Meeting Times: "+arr[i].meetingTimes);
			out.println("Description: "+arr[i].description);
%>
<br>
<%	
		}
		catch(Exception e){
			break;
		}

	}
%>
 <div class="space">                </div>

<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
    </div>

</body>
</html>