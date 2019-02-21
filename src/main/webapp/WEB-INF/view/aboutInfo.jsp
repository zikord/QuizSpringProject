<%-- 
    Document   : userInfoPage
    Created on : Feb 16, 2019, 1:34:37 AM
    Author     : Zika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Page</title>
        <jsp:include page="include/css.jsp"/>        
    </head>

    <body id="page-top">


        <jsp:include page="include/header.jsp"/>

        <div id="wrapper">

            <jsp:include page="include/menu.jsp"/>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">${user.name}</a>
                        </li>
                        <li class="breadcrumb-item active">About</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="jumbotron">
                        <h1>About project</h1></br>
                        
                        <p>Name: <b>Spring MVC Project</b></p>

                        <p>Spring MVC Project is quiz web application that contains 2 parts:</p>
                        <p>First part is User part, from there you can select to take quiz from quiz list, see user info as well as personal highscores for available quizzes and top 10 highscores for all users.</p>
                        <p>Second part is Admin part, from there you can do CRUD methods for users and quizzes.</p></br> </br> 

                        <h1>Contact info</h1></br>
                        <p><i class="fas fa-envelope"></i> <a href="#" target="_blank">  zivan.kordulup@gmail.com</a></p>
                        <p><i class="fab fa-github"></i> <a href="https://github.com/zikord" target="_blank">Git Hub profile</a> </p>
                        <p><i class="fab fa-linkedin"></i> <a href="#"></a></p>

                    </div>

                </div>
            </div>

        </div>
        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>
    </body>
</html>
