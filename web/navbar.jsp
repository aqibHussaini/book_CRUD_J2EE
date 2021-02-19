<nav class="navbar navbar-expand-lg navbar-dark bg-color">
    <a class="navbar-brand" href="Home.jsp"><span class="fa fa-home fa-lg"></span>   Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link " href="addBook.jsp"><span class="fa fa-plus fa-lg ">     </span>  Add Book <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="paginationservlet?page=1"><span class="fa fa-eye fa-lg ">     </span> View Books</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active " style="cursor: pointer;" data-toggle="modal" data-target="#search" ><span class="fa fa-search fa-lg ">     </span>  Search book</a>
                    </li>
                  
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>

