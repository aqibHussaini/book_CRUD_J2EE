/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dao.BookDao;
import com.pojo.Book;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Bhatti
 */
@WebServlet(name = "saveBook", urlPatterns = {"/saveBook"})
@MultipartConfig
public class saveBook extends HttpServlet {

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
            out.println("<title>Servlet saveBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet saveBook at " + request.getContextPath() + "</h1>");
            String booktitle,bookAuthor;
            float bookprice;
            Part pic;
            booktitle=request.getParameter("b_tittile");
            bookAuthor=request.getParameter("b_author");
            bookprice=Float.parseFloat(request.getParameter("b_price"));
            pic=request.getPart("b_pic");
            Book object=new Book();
            object.setBooktitle(booktitle);
            object.setBookauthor(bookAuthor);
            object.setBookprice(bookprice);
            object.setPic(pic.getSubmittedFileName());
            int i=0;
            try
            {
              i=BookDao.SaveBook(object);   
            }
            catch(Exception e)
            {
                out.println(""+e.getMessage());  
            }
            if(i==1)
            {
              out.println("<script>alert('data saved')</script>");  
                InputStream is=pic.getInputStream();
                byte b[]=new byte[is.available()];
                is.read(b);
                File f=new File("C:\\Users\\Bhatti\\Documents\\NetBeansProjects\\mavenproject10\\BooKManagementSystemJSPServlet\\web\\img\\"+pic.getSubmittedFileName());
                FileOutputStream fos=new FileOutputStream(f);
                fos.write(b);
                fos.close();
            }
            else
            {
                 out.println("<script>alert('something went wrong')</script>");  
            }
            
            out.println("</body>");
            out.println("</html>");
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
