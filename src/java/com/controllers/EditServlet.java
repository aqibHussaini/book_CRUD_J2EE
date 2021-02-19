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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Bhatti
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
@MultipartConfig
public class EditServlet extends HttpServlet {

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
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            String title,author;
            Part pic;
            float price;
           int id=Integer.parseInt(request.getParameter("b_id"));
           title=request.getParameter("b_tittle");
           author=request.getParameter("b_author");
           price=Float.parseFloat(request.getParameter("b_price"));
           pic=request.getPart("b_pic");
           int i=-9;
           if(pic.getSubmittedFileName().equals(""))
           {
                Book obj=new Book();
                HttpSession session=request.getSession();
                Book b=(Book)session.getAttribute("book");
                obj.setId(id);
                obj.setBooktitle(title);
                obj.setBookprice(price);
                obj.setBookauthor(author);
                obj.setPic(b.getPic());
                try
                {
                   i=BookDao.Update(obj);
                   if(i==1)
                   {
                     out.println("<h1> data updated succesfully</h1>");      
                   }
                   else 
                   {
                     out.println("<h1> something went wrong</h1>");      
                   }
                } 
                catch(Exception e)
                {
                    
                }
               
           }
           else
           {
             Book obj=new Book();
                HttpSession session=request.getSession();
                Book b=(Book)session.getAttribute("book");
                obj.setId(id);
                obj.setBooktitle(title);
                obj.setBookprice(price);
                obj.setBookauthor(author);
                obj.setPic(pic.getSubmittedFileName());
                try
                {
                   i=BookDao.Update(obj);
                   if(i==1)
                   {
                       File f=new File("C:\\Users\\Bhatti\\Documents\\NetBeansProjects\\mavenproject10\\BookManagementSystem\\web\\img\\"+b.getPic());
                       f.delete();
                       InputStream is=pic.getInputStream();
                       byte bytearr[]=new byte[is.available()];
                      is.read(bytearr);
                       File file= new File("C:\\Users\\Bhatti\\Documents\\NetBeansProjects\\mavenproject10\\BookManagementSystem\\web\\img\\"+pic.getSubmittedFileName());
                       FileOutputStream fos=new FileOutputStream(file);
                       fos.write(bytearr);
                       fos.close();
                     out.println("<h1> data updated succesfully</h1>");      
                   }
                   else 
                   {
                     out.println("<h1> something went wrong</h1>");      
                   }
                } 
                catch(Exception e)
                {
                    
                }
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
