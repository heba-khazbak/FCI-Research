<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FCI Research - Research Page</title>
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
    
    
    
<form method ="post" name="researchForm">
 
   <%	
 	ResearchDAO rD=new ResearchDAO();
	Research[] arr=rD.getResearches();
	int ownerID=Integer.parseInt(request.getSession().getAttribute("ID").toString());
	
	
	boolean check=false;
	for(int i=0;;++i){
		try{
			if(arr[i].getownerID()==ownerID){check=true;break;}
		}
		catch(Exception e){
			break;
		}
	}
	
	if(!check){
		out.write("<script type='text/javascript'>\n");
		out.write("alert(' You have no researches ');\n");
		out.write("window.location.href='HomePage.jsp'");
		out.write("</script>\n");
	}
	
	out.println("Pick one of your researches: <br><br>");
	for(int i=0;;++i){
		try{
			String title=arr[i].getTitle();
			if(arr[i].getownerID()!=ownerID)continue;
%>
<br>
<input type="radio" name="ResearchName" value="<%=title%>"> <%=title%> <br>
<input type="hidden" name="<%=title%>"  value="<%=arr[i].getUrl()%>">
<br>
<%	
		}
		catch(Exception e){
			break;
		}

	}
%>



<input type="submit" value="Edit Research" name="edit" id="Button" onclick="javascript: researchForm.action='editResearchPage.jsp';">
<% out.println(); %>
<input type="submit" value="Delete Research" name="delete" id="Button" onclick="javascript: researchForm.action='deleteResearch';">

</form>   
</div>
 <div class="space">                </div>

    
<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
    </div>
        

    
</body>
</html>