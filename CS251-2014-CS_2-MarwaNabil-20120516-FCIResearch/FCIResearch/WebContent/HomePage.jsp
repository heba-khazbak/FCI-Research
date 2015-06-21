<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FCI Research - Home</title>
<link rel="stylesheet" href="css/Home.css" type="text/css"/>

</head>
    
<body>
    
<div class="Header1">
</div>
    <div class="Header">
    <a href="Login_Page.html">   <img src="css/images/Logo1.png" alt="FCI Research" style="width:354px; height:275px; "></a>
</div>
<div class="cont">         

    
    <h1>Welcome <%=session.getAttribute("name") %> to FCI Research</h1>
<div class="menu">
<a href="createGroupPage.html" class="links"> Create Group </a>
<a href="postResearchPage.jsp" class="links"> Post Research </a>
<a href="ResearchPage.jsp" class="links"> Edit/Delete Research </a>
<a href="showGroups.jsp" class="links"> List your Groups </a>
<a href="Notification_Page.jsp" class="links"> Notification_Page</a>
<a href="ShowResearches.jsp" class="links"> Show Researches</a>
</div>
<br><a id="Button" href="Logout" > Logout</a><br>
        
<br>Navigate To Group
<form action="GroupPage.jsp">
Enter Group's Name: <input type="text" name="groupName_home">
<input type="submit" value="go" name="goToGroup">
</form>
        <div class="space">                </div>
  <div class="space">                </div>
  <div class="space">                </div>

    </div>    
<div class="Footer">
<a  href="HomePage.jsp">FCIResearch</a>
</div>
    

        
</body>
</html>