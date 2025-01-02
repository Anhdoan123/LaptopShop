<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>LaptopShop - AD Admin</title>
                <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
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
                                <h1 class="mt-4">Manager Orders</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"><a href="/admin/order">Order</a></li>
                                    <li class="breadcrumb-item active">Delete</li>
                                </ol>
                                <div class="container mt-3">
                                    <div class="row">
                                        <div class="col-md-9 col-12 mx-auto">
                                            <h1
                                                style="text-align: center; font-family: 'Courier New', Courier, monospace;">
                                                Delete order
                                                with id = ${id}
                                            </h1>
                                            <hr />
                                            <div class="alert alert-danger" role="alert">
                                                Are you sure delete order ?
                                            </div>
                                            <form:form action="/admin/order/delete" method="POST"
                                                modelAttribute="order">
                                                <div class="mb-3" style="display: none;">
                                                    <label class="form-label">ID:</label>
                                                    <form:input type="text" class="form-control" path="id" />
                                                </div>
                                                <button class="btn btn-danger">Delete</button>
                                            </form:form>
                                        </div>
                                    </div>
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
                <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
            </body>

            </html>