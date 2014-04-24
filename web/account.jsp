<%-- 
    Document   : account
    Created on : Apr 13, 2014, 9:09:20 PM
    Author     : Dustin
--%>

<%@page import="java.util.List"%>
<%@page import="edu.spcollege.titanbank.bll.User"%>
<%@page import="edu.spcollege.titanbank.bll.UserRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Information : Titan Bank</title>
        <link rel="stylesheet" type="text/css" href="titanbank.css">
    </head>
    <body>
        <%@page import="edu.spcollege.titanbank.bll.BankAccount" %>
        <%@page import="edu.spcollege.titanbank.bll.BankAccountRepository" %>
        <%@page import="edu.spcollege.titanbank.bll.User" %>
        <%@page import="edu.spcollege.titanbank.bll.UserRepository" %>
        <%! String username = ""; %>
        <%
            username = (String) session.getAttribute("userName");

            UserRepository userRepo = new UserRepository();
            User user = userRepo.findByUserName(username);
    
            BankAccountRepository bankAcctRepo = new BankAccountRepository();
            List<BankAccount> bankAccounts = bankAcctRepo.findByUser(user);
        %>
        <div id="wrapper">
            <header>
                <h1 id="title">Titan Bank</h1>
            </header>
            <nav>
                <a href="account.jsp">Account Information</a>
                <a href="transfers.jsp">Transfer Funds</a>
                <a href="checks.jsp">Manage Checks</a>
                <a href="profile.jsp">Upload Profile/Password</a>
            </nav>
            <div id="accountContent">
                <h1>Account Information</h1>
                <p>Account:<%= user.getUserName() %></p>
                <h3>Checking Account</h3>
                <p>Balance:</p>
                <h3>Savings Account</h3>
                <p>Balance: </p>
            </div>
        </div>
    </body>
</html>
