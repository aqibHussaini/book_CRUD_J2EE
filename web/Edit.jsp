<%-- 
    Document   : Edit
    Created on : Aug 14, 2020, 3:55:21 PM
    Author     : Bhatti
--%>

<%@page import="com.pojo.Book"%>
<%@page import="com.dao.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>JSP Page</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            Book obj = BookDao.getbookbyid(id);
          session.setAttribute("book", obj);

        %>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Update-Form</h1>
                </div>
                <div class="card-body">
                    <form action="EditServlet" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="exampleInputEmail1" name="b_id" value="<%=obj.getId()%>" aria-describedby="emailHelp" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Book title</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" name="b_tittle" value="<%=obj.getBooktitle()%>" aria-describedby="emailHelp" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">book author</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" value="<%=obj.getBookauthor()%>"  name="b_author" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">book price</label>
                            <input type="float" class="form-control" id="exampleInputPassword1" value="<%=obj.getBookprice()%>"  name="b_price" >
                        </div>
                        <div class="form-group">
                            <p>old pic</p>
                            <img src="img/<%=obj.getPic()%>" height="100px" width="100px"/>
                            <input type="file" class="form-control" id="exampleInputPassword1"    name="b_pic" >
                        </div>
                            <div class="text-center">
                                 <button type="update" class="btn btn-warning btn-lg">Submit</button>
                            </div>
                       
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
