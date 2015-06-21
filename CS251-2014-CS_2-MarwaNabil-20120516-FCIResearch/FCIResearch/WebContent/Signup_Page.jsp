<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>FCI Research - SignUp Page</title>
    
<link rel="stylesheet" href="css/SignUp.css" type="text/css"/>
<%@ page import="entities.Tags" %>  
</head>
<body>
<div class="Header1">
</div>
<div class="Header">
   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; ">
    </div>   
<div class="cont">
    
<div class="Form">   
<form id="signUpForm" method ="post" action = "SignUp" >
        Email: <input type="text" name="email" placeholder="example@fci-cu.edu.eg" class="email"/> <br>
        Password: <input type="password" name="password" placeholder="password" class="password"/> <br>
        Name: <input type="text" name="name"  placeholder="name" class="name"/> <br> 
        Job Description: <textarea name="jobDescription" class="description">
        write here
    	</textarea> <br>
        Affiliation: <input type="text" name="affiliation" class="affiliation"/> <br>
        Overview: <input type="text" name="overview" class="overview"/> <br>
        Interests: <br>
        <input type="checkbox" name="interest" class="interest" value="<%=Tags.SW%>"> Semantic Web <br>
		<input type="checkbox" name="interest" class="interest" value="<%=Tags.DM%>"> Data Mining <br>
		<input type="checkbox" name="interest" class="interest" value="<%=Tags.CA%>"> Computer Architecture <br>
		<input type="checkbox" name="interest" class="interest" value="<%=Tags.DS%>"> Decision Support <br>
        
        <input type="submit"   value="Sign Up Now!" id="SignUpButton"/> <br>
        
        </form>
    </div>
    <div class="space">                </div>

    </div>

    <div class="Footer">
        <a  href="HomePage.jsp">FCIResearch</a>        
    </div>
</body>
</html>