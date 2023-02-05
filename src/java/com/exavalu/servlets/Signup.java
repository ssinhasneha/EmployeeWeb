/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.servlets;

import com.exavalu.entities.User;
import com.exavalu.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinha
 */
public class Signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailAddress= request.getParameter("emailAddress");
        String password= request.getParameter("password");
        String firstName= request.getParameter("firstName");
        String lastName= request.getParameter("lastName");
        
        boolean result;
        //boolean result=UserService.doRegister(emailAddress,password,firstName,lastName);
        User user = new User();
        user.setEmailAddress(emailAddress);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        result=UserService.doRegisterUser(user);
        
        if(result)
        {
            String successMsg ="congratulations your account has been  created";
            request.setAttribute("SuccessMsg", successMsg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
        {
            String errorMsg ="Email already  in used";
            request.setAttribute("ErrorMsg", errorMsg);
           request.getRequestDispatcher("signup.jsp").forward(request, response);
           //why we used forward here?
           
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
