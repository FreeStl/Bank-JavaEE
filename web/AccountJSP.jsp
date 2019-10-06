
<%@page import="java.util.Hashtable"%>
<%@page language="java"%>
<%@page import="com.maxcompany.AccountBean"%>
<%@ taglib prefix="calc" uri="/Functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
    </head>
    <body>
        <jsp:useBean id="account" class="com.maxcompany.AccountBean" scope="session"/>
        Hello ${account.balance}!</br>
        Your Mounthly interest is: ${calc:calculate(account)}</br>
        <a href="/Question1/index.html">Main page</a> of the application
    </body>
</html>
