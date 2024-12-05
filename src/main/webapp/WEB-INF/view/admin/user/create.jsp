<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link rel="stylesheet" href="/css/demo.css"> -->

            </head>

            <body>
                <div class="container mt-3">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h1 style="text-align: center; font-family: 'Courier New', Courier, monospace;">Create user
                            </h1>
                            <hr />
                            <form:form method="POST" action="/admin/user/create" modelAttribute="newUser">
                                <div class="mb-3">
                                    <label class="form-label">Email:</label>
                                    <form:input type="email" class="form-control" path="email" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Password:</label>
                                    <form:input type="password" class="form-control" path="password" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Phone number:</label>
                                    <form:input type="phone" class="form-control" path="phone" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Full name:</label>
                                    <form:input type="text" class="form-control" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address:</label>
                                    <form:input type="text" class="form-control" path="address" />
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>