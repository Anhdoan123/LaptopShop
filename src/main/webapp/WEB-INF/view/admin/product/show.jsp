<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>Dashboard - AD Admin</title>
                <link href="../css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <!-- header -->
                <jsp:include page="../layout/header.jsp" />
                <!-- header -->
                <div id="layoutSidenav">
                    <div id="layoutSidenav_nav">
                        <!-- sidebar -->
                        <jsp:include page="../layout/sidebar.jsp" />
                        <!-- sidebar -->
                    </div>
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Dashboard</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Products</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="d-flex d-flex justify-content-between">
                                        <h3>Table products</h3>
                                        <a class="btn btn-primary" href="/admin/product/create" role="button">Create a
                                            product</a>
                                    </div>
                                    <hr>
                                    <table class="table table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Factory</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listProduct}" var="product">
                                                <tr>
                                                    <th>${product.id}</th>
                                                    <td>${product.name}</td>
                                                    <td>
                                                        <fmt:formatNumber value="${product.price}" type="number"
                                                            pattern="#,###.00" />
                                                    </td>
                                                    <td>${product.factory}</td>
                                                    <td>
                                                        <a href="/admin/product/${product.id}"
                                                            class="btn btn-success">View</a>
                                                        <a href="/admin/product/update/${product.id}"
                                                            class="btn btn-warning">Update</a>
                                                        <a href="/admin/product/delete/${product.id}"
                                                            class="btn btn-danger">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </main>
                        <!-- footer -->
                        <jsp:include page="../layout/footer.jsp" />
                        <!-- footer -->
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="../js/scripts.js"></script>
            </body>

            </html>