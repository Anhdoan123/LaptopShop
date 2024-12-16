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
                                <h1 class="mt-4">Manager Users</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"><a href="/admin/user">User</a></li>
                                    <li class="breadcrumb-item active">View</li>
                                </ol>
                                <div class="container mt-5">
                                    <div class="d-flex justify-content-center">
                                        <h3>User detail with id = ${id}</h3>
                                    </div>
                                    <hr>
                                    <div class="d-flex justify-content-center">
                                        <div class="card" style="width: 70%;">
                                            <div class="card-header">
                                                <b>User Information</b>
                                            </div>
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item">ID: ${userDetail.id}</li>
                                                <li class="list-group-item">Email: ${userDetail.email}</li>
                                                <li class="list-group-item">Address: ${userDetail.address}</li>
                                                <li class="list-group-item">Full Name: ${userDetail.fullName}</li>
                                                <li class="list-group-item">Phone: ${userDetail.phone}</li>
                                                <li class="list-group-item">Role: ${userDetail.role.name}</li>
                                            </ul>
                                        </div>

                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <div style="width: 70%;">
                                            <a href="/admin/user" class="btn btn-primary mt-3">Back</a>
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