<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FCI Reseach - Edit Research</title>
<link rel="stylesheet" href="css/editResearchPage.css" type="text/css"/>    
</head>

<body>

<%@ page import="entities.Tags" %> 
<%@ page import="dao.*" %> 
<%@ page import="entities.*" %> 

<%
	ResearchDAO rD=new ResearchDAO();
	Research arr[]=rD.getResearches();
	
	Research r=null;
	String url=request.getParameter(request.getParameter("ResearchName"));

	for(int i=0;;++i){
		try{
			if(arr[i].getUrl().equals(url)){
				r=new Research(arr[i].getTitle(),arr[i].getUrl(),arr[i].getDescription(),arr[i].getownerID());
				break;
			}
		}
		catch(Exception e){
			break;
		}
	}
%>

<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>
<div class="cont">         


<div class="Form">
<form method="post" action="editResearch">
Edit Research Title:<input type="text" name ="editedTitle" class="Title" value="<%=r.getTitle() %>"><br>
Edit Research url:<input type="text" name ="editedurl" class="url" value="<%=r.getUrl() %>"><br>
Edit Description:<br><textarea name="editedDescription_r" class="description" rows="3" cols="25"><%=r.getDescription() %></textarea><br>
<input type="checkbox" name="interest_research_edit" class="interest" value="<%=Tags.SW%>"> Semantic Web <br>
<input type="checkbox" name="interest_research_edit" class="interest" value="<%=Tags.DM%>"> Data Mining <br>
<input type="checkbox" name="interest_research_edit" class="interest" value="<%=Tags.CA%>"> Computer Architecture <br>
<input type="checkbox" name="interest_research_edit" class="interest" value="<%=Tags.DS%>"> Decision Support <br>
<input type="hidden" name="oldURL" value="<%=url%>">
   
<input type="submit" value="go" name="go" id="Button" >

</form>
</div>
    
<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
</div>
        

</body>
</html>