<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <link href="../css/styles.css" rel="stylesheet" />
                <title>Document</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="d-flex d-flex justify-content-between">
                        <h1>Table users</h1>
                        <a class="btn btn-primary btn-lg" href="/admin/user/create" role="button">Create a user</a>
                    </div>
                    <hr>
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Email</th>
                                <th>Full Name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listUser}" var="user">
                                <tr>
                                    <th>${user.id}</th>
                                    <td>${user.email}</td>
                                    <td>${user.fullName}</td>
                                    <td>
                                        <button class="btn btn-success">View</button>
                                        <button class="btn btn-warning">Update</button>
                                        <a href="/admin/user/delete?id=${user.id}">
                                            <button class="btn btn-danger">Delete</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>