<%@page import="java.util.List"%>
<%@page import="com.pojo.Book"%>
<%@page import="com.dao.BookDao"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>View Book</title>
    </head>
    <body >
        <%@include file="navbar.jsp" %> 
        <div class="container text-center mt-2">

            <h1>View Books</h1>

        </div>
        <div class="container mt-5">
            <table class="table ">
                <thead class="thead-dark ">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tittle</th>
                        <th scope="col">Author</th>
                        <th scope="col">Price</th>
                        <th scope="col">Pic</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody >
                    <%
                        int total = 1;
                        int pageid = 1;
                        List<Book> list = null;
                        pageid = Integer.parseInt("" + session.getAttribute("page"));
                        total = Integer.parseInt("" + session.getAttribute("total"));
                        if (pageid == 1) {
                            total = 2;
                            pageid = 1;
                        } else {
                            total = 2;
                            pageid = (pageid*total)-1;
                        }
                        list = BookDao.getAllBooksByLimiting(pageid, total);
                        for (Book b : list) {
                    %>
                    <tr>
                        <th scope="row"><%=b.getId()%></th>
                        <td><%=b.getBooktitle()%></td>
                        <td><%=b.getBookauthor()%></td>
                        <td><%=b.getBookprice()%></td>
                        <td><img src="img/<%=b.getPic()%>" height="100px" width="100px" class="img-fluid"/></td>
                        <td><a class="fa fa-edit fa-lg  fa-5x text-decoration-none" href="Edit.jsp?id=<%=b.getId()%>"></a></td>
                        <td><a class="fa fa-trash fa-lg  fa-5x text-decoration-none" href="delete?id=<%=b.getId()%>"></a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
                List<Book> templ = BookDao.getAllbooks();
                for (int i = 1; i <=templ.size()/2; i++) {
            %>  
            <a class="btn btn-outline-success" href="paginationservlet?page=<%=i%>"><%=i%></a>
            <%
                }
            %>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>