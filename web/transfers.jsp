<%-- 
    Document   : transfers
    Created on : Apr 13, 2014, 9:15:49 PM
    Author     : Dustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Funds : Titan Bank</title>
        <link rel="stylesheet" type="text/css" href="titanbank.css">
    </head>
    <body>
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
            <div id="transfersContent">
                <h1>Transfer Funds</h1>
                <form name="transferForm" action="" method="POST" id="transferForm">
                    Transfer from Account:
                    <select name="typeOfAccount" id="transferFrom">
                        <option>Checking</option>
                        <option>Savings</option>
                    </select><br><br>
                    Transfer to Account:
                    <select name="destination" id="transferTo">
                        <option>Savings</option>
                        <option>Checking</option>
                    </select><br><br>
                    Schedule Transfer:
                    <input type="date" name="transferDate" id="transferDate"><br><br>
                    Amount to Transfer:
                    <input type="text" name="transferAmount" value="0.00" /><br><br>
                    <input type="reset" value="Clear Form" /><input type="submit" value="Transfer" id="submit" />
                </form>
                <table id="transferStatus">
                    <tr>
                        <th>Transfers</th>
                        <th>Status</th>
                    </tr>
                    <tr>
                        <td>111</td>
                        <td>111</td>
                    </tr>
                    <tr>
                        <td>222</td>
                        <td>222</td>
                    </tr>
                    <tr>
                        <td>333</td>
                        <td>333</td>
                    </tr>
                </table> 
                <!--<div id="transferId">
                    <h3>Transfers</h3>
                    <p>***</p>
                    <p>***</p>
                    <p>***</p>
                    <p>***</p>
                </div>
                <div id="transferStatus">
                    <h3>Status</h3>
                    <p>***</p>
                    <p>***</p>
                    <p>***</p>
                    <p>***</p>
                </div>-->
            </div>
        </div>
    </body>
</html>
