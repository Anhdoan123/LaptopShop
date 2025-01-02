<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <title> Giỏ hàng - Laptopshop</title>
                <meta content="width=device-width, initial-scale=1.0" name="viewport">
                <meta content="" name="keywords">
                <meta content="" name="description">

                <!-- Google Web Fonts -->
                <link rel="preconnect" href="https://fonts.googleapis.com">
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                <link
                    href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                    rel="stylesheet">

                <!-- Icon Font Stylesheet -->
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                    rel="stylesheet">

                <!-- Libraries Stylesheet -->
                <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


                <!-- Customized Bootstrap Stylesheet -->
                <link href="/client/css/bootstrap.min.css" rel="stylesheet">

                <!-- Template Stylesheet -->
                <link href="/client/css/style.css" rel="stylesheet">

                <meta name="_csrf" content="${_csrf.token}" />
                <meta name="_csrf_header" content="${_csrf.headerName}" />
                <style>
                    * {
                        box-sizing: border-box;
                    }

                    body {
                        background: #ffffff;
                        background: linear-gradient(to bottom, #ffffff 0%, #e1e8ed 100%);
                        height: 100%;
                        margin: 0;
                        background-repeat: no-repeat;
                        background-attachment: fixed;
                    }

                    .wrapper-1 {
                        width: 100%;
                        height: 100vh;
                        display: flex;
                        flex-direction: column;
                    }

                    .wrapper-2 {
                        padding: 30px;
                        text-align: center;
                    }

                    h1 {
                        font-family: 'Kaushan Script', cursive;
                        font-size: 4em;
                        letter-spacing: 3px;
                        color: #86c511;
                        margin: 0;
                        margin-bottom: 20px;
                    }

                    .wrapper-2 p {
                        margin: 0;
                        font-size: 1.3em;
                        color: #aaa;
                        font-family: 'Source Sans Pro', sans-serif;
                        letter-spacing: 1px;
                    }

                    .go-home {
                        color: #fff;
                        background: #86c511;
                        border: none;
                        padding: 10px 50px;
                        margin: 30px 0;
                        border-radius: 30px;
                        text-transform: capitalize;
                        box-shadow: 0 10px 16px 1px rgba(174, 199, 251, 1);
                    }

                    .footer-like {
                        margin-top: auto;
                        background: #D7E6FE;
                        padding: 6px;
                        text-align: center;
                    }

                    .footer-like p {
                        margin: 0;
                        padding: 4px;
                        color: #5892FF;
                        font-family: 'Source Sans Pro', sans-serif;
                        letter-spacing: 1px;
                    }

                    .footer-like p a {
                        text-decoration: none;
                        /* Bỏ gạch dưới */
                        color: #5892FF;
                        font-weight: 600;
                    }

                    @media (min-width: 360px) {
                        h1 {
                            font-size: 4.5em;
                        }

                        .go-home {
                            margin-bottom: 20px;
                        }
                    }

                    @media (min-width: 600px) {
                        .content {
                            max-width: 1000px;
                            margin: 0 auto;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            min-height: 100vh;
                            padding: 0 20px;
                        }

                        .wrapper-1 {
                            height: initial;
                            max-width: 620px;
                            margin: 0 auto;
                            margin-top: 50px;
                            box-shadow: 4px 8px 40px 8px rgba(88, 146, 255, 0.2);
                        }
                    }
                </style>

            </head>

            <body>

                <!-- Spinner Start -->
                <div id="spinner"
                    class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
                    <div class="spinner-grow text-primary" role="status"></div>
                </div>
                <!-- Spinner End -->

                <jsp:include page="../layout/header.jsp" />

                <!-- Body -->
                <div class="content">
                    <div class="wrapper-1">
                        <div class="wrapper-2">
                            <h1>Thank you!</h1>
                            <p style="margin-bottom: 50px;">Thank you for your order.</p>
                            <a href="/" class="go-home">go home</a>

                        </div>

                    </div>
                </div>
                <!-- BodyEnd -->





                <!-- Back to Top -->
                <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
                        class="fa fa-arrow-up"></i></a>


                <!-- JavaScript Libraries -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                <script src="/client/lib/easing/easing.min.js"></script>
                <script src="/client/lib/waypoints/waypoints.min.js"></script>
                <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
                <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

                <!-- Template Javascript -->
                <script src="/client/js/main.js"></script>
            </body>

            </html>