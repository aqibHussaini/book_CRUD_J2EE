<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Hello, world!</title>
  </head>
  <body >
    <!--  navbar start -->
    <%@include file="navbar.jsp" %>
    <!--  navbar end-->
   
        <div class="container mt-5" >
            <div class="row">
                
                <div class="col-md-6  offset-md-3">
                    <div class="card shadow-lg ">
                        <div class="card-header   text-center bg-primary">
                        
                            <h4 class="text-white">Register here</h4>
                        </div>
                        <div class="card-body ">
                            <form action="saveBook" method="post" id="Rform" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label >Book Tittile:</label>
                                    <input type="text" name="b_tittile" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label >Book Author:</label>
                                    <input type="text" name="b_author" class="form-control"  required>
                                </div>
                                <div class="form-group">
                                    <label >Book price:</label>
                                    <input type="float" name="b_price" class="form-control"  required>
                                </div>
                                <div class="form-group">
                                    <input type="file" name="b_pic"/>
                                </div>
                               

                                <div class="text-center">
                                    <button type="submit" class="btn btn-outline-success btn-lg text-center ">Submit</button>
                                </div>

                            </form>
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