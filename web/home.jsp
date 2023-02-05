<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.exavalu.empweb.utils.JDBCConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.exavalu.entities.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:if test="${empty sessionScope.User}">
    <jsp:forward page="login.jsp"/>
</c:if>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.108.0">
        <title>Product example Â· Bootstrap v5.3</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">


        <link href="css/menu_css.css" rel="stylesheet">


        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">




        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">



        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"/>
    </head>
    <body>



        <jsp:include page="menu.jsp"></jsp:include>

        <c:if test="${not empty requestScope.SuccessMsg}">
            <div class="alert alert-success" role="alert">
                ${requestScope.SucessMsg}
            </div>
        </c:if>


        <c:set var="empList" value="${requestScope.EmpList}"/>



        <table class="table" id="example">
            <thead>
                <tr>  
                    <th>
                        Employee Id
                    </th>
                    <th>
                        First Name
                    </th>
                    <th>
                        Last Name
                    </th>
                    <th>
                        Address
                    </th>
                    <th>
                        Phone
                    </th>
                    <th>
                        Gender
                    </th>
                    <th>
                        Age
                    </th>
                    <th>
                        Department
                    </th>
                    <th>
                        Role
                    </th>
                    <th>
                        Basic Salary
                    </th>
                    <th>
                        Car Allowance
                    </th>
                    <th>
                                                Action</th>
                </tr>

            </thead>
            
            <c:forEach items="${empList}" var="emp">



                <tr>
                    <td>
                        
                        ${emp.getEmployeeId()}
                    </td>
                    <td>
                      
                        ${emp.getFirstName()} 
                    </td>
                    <td>
                        
                        ${emp.getLastName()}
                    </td>
                    <td>
                      
                        ${emp.getAddress()} 
                    </td>
                    <td>
                      
                        ${emp.getPhone()}
                    </td>
                    <td>
                        
                        ${emp.getGender()}
                    </td>
                    <td>
                      
                        ${emp.getAge()}
                    </td>
                    <td>

                        ${emp.getDepartmentName()}
                    </td>
                    <td>
                      
                        ${emp.getRoleName()}
                    </td>
                    <td>
                        
                        ${emp.getBasicSalary()}
                    </td>
                    <td>
                        
                        ${emp.getCarAllowance()}
                    </td>
                    <td> 
                        <a href=EditEmployee?employeeId=${emp.getEmployeeId()}> Edit</a>              
                    </td>
                </tr>
            </c:forEach>

        </table>

        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>


        <!--        <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        -->

    </body>
</html>
