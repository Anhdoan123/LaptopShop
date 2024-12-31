<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
                        crossorigin="anonymous"></script>
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
                                    <h1 class="mt-4">Manager products</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                        <li class="breadcrumb-item active"><a href="/admin/product">product</a></li>
                                        <li class="breadcrumb-item active">View</li>
                                    </ol>
                                    <div class="container mt-5">
                                        <div class="d-flex justify-content-center">
                                            <h3>product detail with id = ${id}</h3>
                                        </div>
                                        <hr>
                                        <div class="d-flex justify-content-center">
                                            <div class="card" style="width: 70%;">
                                                <div class="card-header">
                                                    <b>product Information</b>
                                                </div>
                                                <ul class="list-group list-group-flush">
                                                    <li class="list-group-item">ID: ${productDetail.id}</li>
                                                    <li class="list-group-item">Name: ${productDetail.name}</li>
                                                    <li class="list-group-item">Price:
                                                        <fmt:formatNumber value="${productDetail.price}" type="number"
                                                            pattern="#,###.00" />
                                                    </li>
                                                    <li class="list-group-item">Detail description:
                                                        ${productDetail.detailDesc}</li>
                                                    <li class="list-group-item">Short description
                                                        ${productDetail.shortDesc}
                                                    </li>
                                                    <li class="list-group-item">Quantity: ${productDetail.quantity}</li>
                                                    <li class="list-group-item">Factory: ${productDetail.factory}</li>
                                                    <li class="list-group-item">
                                                        <div class="col-12">
                                                            Image
                                                            <img src="/images/product/${productDetail.image}"
                                                                style="max-height: 250px;display: none;"
                                                                alt="avatar preview" id="avatarPreview"
                                                                onload=" this.style.display='block';"
                                                                onerror=" this.style.display='none';">
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>

                                        </div>
                                        <div class="d-flex justify-content-center">
                                            <div style="width: 70%;">
                                                <a href="/admin/product" class="btn btn-primary mt-3">Back</a>
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