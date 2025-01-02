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
                                    <h1 class="mt-4">Order Detail</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                        <li class="breadcrumb-item active"><a href="/admin/order">Order</a></li>
                                        <li class="breadcrumb-item active">Detail</li>
                                    </ol>
                                    <div class="mt-5">
                                        <div class="d-flex d-flex justify-content-between">
                                            <h3>Order with id ${id}</h3>

                                        </div>
                                        <hr>
                                        <table class="table table-hover table-bordered" style="text-align: center;">
                                            <thead>
                                                <tr>
                                                    <th>Sản phẩm</th>
                                                    <th>Tên</th>
                                                    <th>Giá cả</th>
                                                    <th>Số lượng</th>
                                                    <th>Thành tiền</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listOrderDetail}" var="orderDetail">
                                                    <tr>
                                                        <th scope="row">
                                                            <div class="d-flex align-items-center">
                                                                <img src="/images/product/${orderDetail.product.image}"
                                                                    class="img-fluid me-5 rounded-circle"
                                                                    style="width: 80px; height: 80px;" alt="" alt="">
                                                            </div>
                                                        </th>
                                                        <td>
                                                            <p class="mb-0 mt-4"><a
                                                                    href="/product/${orderDetail.product.id}"
                                                                    target="_blank">${orderDetail.product.name}</a>
                                                            </p>
                                                        </td>
                                                        <td>
                                                            <p class="mb-0 mt-4">
                                                                <fmt:formatNumber value=" ${orderDetail.product.price}"
                                                                    type="number" pattern="#,### đ" />
                                                            </p>
                                                        </td>
                                                        <td>
                                                            <p class="mb-0 mt-4" style="text-align: center;">
                                                                ${orderDetail.quantity}
                                                            </p>

                                                        </td>
                                                        <td>
                                                            <p class="mb-0 mt-4">

                                                                <fmt:formatNumber value="${orderDetail.product.price *
                                                                orderDetail.quantity}" type="number"
                                                                    pattern="#,### đ" />
                                                            </p>
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
                    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
                </body>

                </html>