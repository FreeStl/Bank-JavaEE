<%@page import="java.util.Date"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page language="java"%>
<%@ page import="com.maxcompany.AccountBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registratione</title>
    </head>
    <body>      
        <jsp:useBean id="account" class="com.maxcompany.AccountBean" />
        <jsp:setProperty name="account" property="*" />
        
        <%
                String name = account.getName();
                String pass = account.getPassword();
                account.setDateCreated(new Date());
                
                if(name != null && !name.equals("") && !pass.equals("")){
                    String realPath = application.getRealPath("/WEB-INF/files/");
                    System.out.println("Path:"+realPath+"\\"+name+".ser");         
                    FileOutputStream fos = new FileOutputStream(realPath+"\\"+name+".ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(account);
                    oos.close();
                    request.getRequestDispatcher("/logged").forward(request, response);
                }
                
            
        %>
        <h2>Please register:</h2>
        <form action="/WebApplication1/registration" method="POST">
            Name: <input type="text" name="name" required="true"></br>
            Password: <input type="password" name="password" required="true">
            </br>Balance <input type="number" name="balance" required="true"></br>
            
            <input type="submit" value="Submit">
        </form>
        
        <a href="index.html">Back to Main Page</a>
    </body>
</html>
