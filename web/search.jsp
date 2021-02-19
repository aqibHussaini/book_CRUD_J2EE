<%-- 
    Document   : search
    Created on : Aug 14, 2020, 9:23:44 PM
    Author     : Bhatti
--%>

<%@page import="com.pojo.Book"%>
<%@page import="com.dao.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = BookDao.getbookbyid(id);
        %>
        
        <div class="container mt-5 ">
            <div >
                <a class="btn btn-danger text-white" href="viewBook.jsp">View All</a>
            </div>
            <div class="row">
                <div class="col-md-6 offset-md-3 ">
                    <div class="card" style="width: 18rem;">

                        <img class="card-img-top" src="img/<%=book.getPic()%>" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">BookTittle = <%=book.getBooktitle()%></h5>
                            <p class="card-text">BookAuthor = <%=book.getBookauthor()%></p>
                            <p class="card-text">BookPrice = <%=book.getBookprice()%></p>

                        </div>
                    </div>
                </div>   
            </div>

        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>