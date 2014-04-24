/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.titanbank.controllers;

import edu.spcollege.titanbank.bll.AuthenticationService;
import edu.spcollege.titanbank.bll.Customer;
import edu.spcollege.titanbank.bll.InvalidPasswordException;
import edu.spcollege.titanbank.bll.UserNotFoundException;
import edu.spcollege.titanbank.bll.UserRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dustin
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("uName");
        String pwd = request.getParameter("pWord");
        String loginResultMsg = "";
        AuthenticationService authenticator = new AuthenticationService(new UserRepository());
        
        try {
            Customer c = authenticator.login(userName, pwd);
            loginResultMsg = "You are logged in!";
        } catch (UserNotFoundException | InvalidPasswordException ex) {
            loginResultMsg = "Sorry, Incorrect Password, Try Again.";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + loginResultMsg + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
