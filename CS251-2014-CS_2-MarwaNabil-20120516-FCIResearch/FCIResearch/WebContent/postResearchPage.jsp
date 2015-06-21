<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    
<title>FCI Research - Post Reasearch Page</title>    
<link rel="stylesheet" href="css/postResearchPage.css" type="text/css"/>

<%@ page import="entities.Tags" %>  
</head>
<body>

<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>
<div class="cont">         
    
<div class="Form">
<form method="post" action="postResearch">

    Research Title:<input type="text" class="Title" name ="title"><br>
Research url:<input type="text" class="url" name ="url"><br>
Add Description:<br><textarea name="description" class="description" rows="3" cols="25"></textarea><br>
<input type="checkbox" name="interest_research" class="interest" value="<%=Tags.SW%>"> Semantic Web <br>
<input type="checkbox" name="interest_research" class="interest" value="<%=Tags.DM%>"> Data Mining <br>
<input type="checkbox" name="interest_research" class="interest" value="<%=Tags.CA%>"> Computer Architecture <br>
<input type="checkbox" name="interest_research" class="interest" value="<%=Tags.DS%>"> Decision Support <br>

   
<input type="submit" value="Post" id="Button" name="Post">

</form>
</div>

 <div class="space">                </div>
    
<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
    </div>
        

    

</body>
</html>