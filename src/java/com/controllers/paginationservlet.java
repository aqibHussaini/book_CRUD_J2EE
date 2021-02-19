/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dao.BookDao;
import com.pojo.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bhatti
 */
public class paginationservlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet paginationservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet paginationservlet at hello new change" + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet paginationservlet at hello </h1>");
               int total=1;
          int pageid=1;
         pageid =Integer.parseInt(""+request.getParameter("page"));
         out.println("<h1>Servlet paginationservlet at hello </h1>"+pageid);
         out.print("hi kkjk"+pageid);
         out.println("<h1>Servlet paginationservlet at hello </h1>"+pageid);
         out.print("hi kkjk"+pageid);
         out.println("<h1>Servlet paginationservlet at hello </h1>"+pageid);
         out.print("hi kkjk"+pageid);
         out.println("<h1>Servlet paginationservlet at hello </h1>"+pageid);
         out.print("hi kkjk"+pageid);
         out.println("<h1>Servlet paginationservlet at hello </h1>"+pageid);
         out.print("hi kkjk"+pageid);
//       
            HttpSession session=request.getSession();
            session.setAttribute("page", pageid);
            session.setAttribute("total", total);
            response.sendRedirect("viewBook.jsp");
            out.println("</body>");
            
            out.println("</html>");
        }
        catch(Exception e)
        {
            response.getWriter().print("error"+e.getMessage());
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
