
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Signin Template · Bootstrap v5.0</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">



        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" >

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.0/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
        <link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#7952b3">





        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
    </head>
    <body class="text-center">

        <main class="form-signin">
            <form action="Login" method="Post">
                <img class="mb-4" src="css/login.jpg" alt="" width="72" height="57">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <!-- <% if (request.getAttribute("ErrorMsg") != null) {%>
                 <div class="alert alert-danger" role="alert">
                <%=request.getAttribute("ErrorMsg")%>
            </div>
                <% } %>  -->

                <c:if test="${not empty requestScope.ErrorMsg}">
                    <div class="alert alert-danger" role="alert">
                        ${requestScope.ErrorMsg}
                    </div>
                </c:if>



                <!-- <% if (request.getAttribute("SuccessMsg") != null) {%>
                 <div class="alert alert-success" role="alert">
                <%=request.getAttribute("SuccessMsg")%>
            </div>
                <% }%> -->

                <c:if test="${not empty requestScope.SuccessMsg}">
                    <div class="alert alert-success" role="alert">
                        ${requestScope.SuccessMsg}
                    </div>
                </c:if>


                <!--    <div class="alert alert-danger" role="alert">
                <%=request.getAttribute("ErrorMsg")%>
            </div>-->

                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                </div>

                <div>
                    <h4>New user?</h4>
                    <button class="w-100 btn btn-lg btn-secondary" type="" ><a href="signup.jsp">Sign up</a></button>
                </div>
                <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
            </form>
        </main>



    </body>
</html>
