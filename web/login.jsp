<%-- 
    Document   : login
    Created on : Aug 11, 2019, 5:11:09 PM
    Author     : user
--%>

<%@page language="java"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <h3>Please enter your userid and password to see your account statement:</h3><p>
    <form action="/WebApplication1/loginServlet" method="POST">
        Userid : <input type="text" name="userid"><br><br>
        Password : <input type="password" name="password"><br><br>
        <input type="submit" value="Show Statement">
    </form>
    
    <%
        String template = "<form action=\"/WebApplication1/loginServlet\" method=\"POST\">\r\n    "
                 + "   Userid : <input type=\"text\" name=\"userid\"><br><br>\r\n"
                 + "        Password : <input type=\"password\" name=\"password\">"
                 + "<br><br>\r\n        <input type=\"submit\" value=\"Show Statement\">\r\n    </form>";
     if(request.getAttribute("fail") != null){
         PrintWriter pw = response.getWriter();
         pw.write(template);
         pw.write("<h3>"+request.getAttribute("fail").toString()+"</h3>");
         pw.close();
         request.removeAttribute("fail");
     }
    %>
</html>
