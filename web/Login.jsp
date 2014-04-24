<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Login
    Created on : Apr 8, 2014, 12:30:44 AM
    Author     : Dustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login : Titan Bank</title>
        <link rel="stylesheet" type="text/css" href="titanbank.css">
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1 id="title">Titan Bank</h1>
            </header>
            <form name="loginForm" action="LoginServlet" method="POST" id="loginForm">
                User Name:
                <input type="text" name="uName" required/><br>
                Password:
                <input type="password" name="pWord" required/><br>
                <input type="submit" value="Login" id="submit" />
            </form>
            <h3>User Name= atillman / Password = password</h3>
        </div>
    </body>
</html>
