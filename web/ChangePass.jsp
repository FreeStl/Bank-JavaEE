<%-- 
    Document   : ChangePass
    Created on : 9-Jul-2019, 10:41:24 PM
    Author     : user
--%>

<%@page import="java.io.PrintWriter"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <h2>Please change the password</h2></br>
        <form action="/WebApplication1/changePassServlet" method="POST">
            <h4>Username:</h4> <input type="text" name="user-name"><br><br>
            <h4>Old Password:</h4> <input type="password" name="old-password"><br><br>
            <h4>New Password:</h4> <input type="password" name="new-password"><br><br>
            <h4>Confirm New Password:</h4> <input type="password" name="new-password-confirm"><br><br>
            <input type="submit" value="Apply"><br><br>    
            <input type="reset" value="Reset" />
        </form>
        
        <%
            String template = "<form action=\"/WebApplication1/changePassServlet\" method=\"POST\">"
                    + "<h4>Username:</h4> <input type=\"text\" name=\"user-name\"><br><br>"
                    + "<h4>Old Password:</h4> <input type=\"password\" name=\"old-password\"><br><br>"
                    + " <h4>New Password:</h4> <input type=\"password\" name=\"new-password\"><br><br>"
                    + "<h4>Confirm New Password:</h4> <input type=\"password\" name=\"new-password-confirm\"><br><br>"
                    + "<input type=\"submit\" value=\"Apply\"><br><br>"
                    + "<input type=\"reset\" value=\"Reset\" /></form>";
            if(request.getAttribute("changeFail") != null){
            PrintWriter pw = response.getWriter();
            pw.write(template);
            pw.write("<h3>"+request.getAttribute("changeFail").toString()+"</h3>");
            pw.close();
            request.removeAttribute("changeFail");
     }
         %>   
           
        <a href="index.html">Back to Main Page</a>
        
    </body>
</html>
