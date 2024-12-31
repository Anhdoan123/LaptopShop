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
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ display: "block" });
                        });
                    });
                </script>

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
                                <h1 class="mt-4">Manager products</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"><a href="/admin/product">product</a></li>
                                    <li class="breadcrumb-item active">Create</li>
                                </ol>
                                <div class="container mt-3 mb-3">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h1
                                                style="text-align: center; font-family: 'Courier New', Courier, monospace;">
                                                Create product
                                            </h1>
                                            <hr />
                                            <form:form method="POST" action="/admin/product/create"
                                                modelAttribute="newProduct" class="row g-3"
                                                enctype="multipart/form-data">
                                                <div class="col-md-6">
                                                    <c:set var="errorName">
                                                        <form:errors path="name" cssClass="invalid-feedback" />
                                                    </c:set>
                                                    <label class="form-label">Name</label>
                                                    <form:input type="text"
                                                        class="form-control ${not empty errorName? 'is-invalid':''}"
                                                        path="name" />
                                                    ${errorName}
                                                </div>
                                                <div class="col-md-6">
                                                    <c:set var="errorPrice">
                                                        <form:errors path="price" cssClass="invalid-feedback" />
                                                    </c:set>
                                                    <label class="form-label">Price</label>
                                                    <form:input type="number"
                                                        class="form-control ${not empty errorPrice? 'is-invalid':''}"
                                                        path="price" />
                                                    ${errorPrice}
                                                </div>
                                                <div class="col-md-12">
                                                    <c:set var="errorDetailDesc">
                                                        <form:errors path="detailDesc" cssClass="invalid-feedback" />
                                                    </c:set>
                                                    <label class="form-label">Detail description</label>
                                                    <form:textarea type="text"
                                                        class="form-control ${not empty errorDetailDesc? 'is-invalid':''}"
                                                        path="detailDesc" rows="3" />
                                                    ${errorDetailDesc}
                                                </div>
                                                <div class="col-6">
                                                    <c:set var="errorShortDesc">
                                                        <form:errors path="shortDesc" cssClass="invalid-feedback" />
                                                    </c:set>
                                                    <label class="form-label">Short description</label>
                                                    <form:input type="text"
                                                        class="form-control ${not empty errorShortDesc? 'is-invalid':''}"
                                                        path="shortDesc" />
                                                    ${errorShortDesc}
                                                </div>
                                                <div class="col-6">
                                                    <c:set var="errorQuantity">
                                                        <form:errors path="quantity" cssClass="invalid-feedback" />
                                                    </c:set>
                                                    <label class="form-label">Quantity</label>
                                                    <form:input type="number"
                                                        class="form-control ${not empty errorQuantity? 'is-invalid':''}"
                                                        path="quantity" />
                                                    ${errorQuantity}
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="form-label">Factory</label>
                                                    <form:select class=" form-select" path="factory">
                                                        <form:option value="Apple">Apple(MacBook)</form:option>
                                                        <form:option value="Lenovo">Lenovo (ThinkPad)</form:option>
                                                        <form:option value="Asus">Asus (ROG)</form:option>
                                                        <form:option value="Acer">Acer (Predator)</form:option>
                                                        <form:option value="MSI">MSI (Stealth)</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="form-label">Target</label>
                                                    <form:select class=" form-select" path="target">
                                                        <form:option value="Gaming">Gaming</form:option>
                                                        <form:option value="Ultrabook">Ultrabook</form:option>
                                                        <form:option value="Workstation">Workstation</form:option>
                                                        <form:option value="General Use">General Use</form:option>
                                                        <form:option value="Student">Student</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <label for="avatarFile" class="form-label">Image</label>
                                                    <input class="form-control" type="file" id="avatarFile"
                                                        accept=".png, .jpg, .jpeg" name="imgFile" />
                                                </div>
                                                <div class="col-12">
                                                    <img style="max-height: 250px;display: none;" alt="avatar preview"
                                                        id="avatarPreview">
                                                </div>
                                                <div class="col-12">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                </div>
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