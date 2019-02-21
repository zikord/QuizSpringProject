<%-- 
    Document   : index1
    Created on : Aug 1, 2018, 4:45:33 PM
    Author     : Zika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
        <jsp:include page="include/css.jsp"/>
    </head>

    <s:url var="url_userInfo" value="/user/info"/>
    <s:url var="url_userScores" value="/user/highscores"/>

    <body id="page-top">


        <jsp:include page="include/header.jsp"/>

        <div id="wrapper">

            <jsp:include page="include/menu.jsp"/>

            <div id="content-wrapper">

                <div class="container-fluid">


                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">${user.name}</a>
                        </li>
                        <li class="breadcrumb-item active">Final Score</li>
                    </ol>

                    <!-- Questions and answers -->

                    <div class="jumbotron">
                        <h1 class="display-4">QUIZ RESULT</h1>
                        <hr class="my-4">
                        <p class="boldText">${score}</p>
                        <p> If you want to check personal best scores go to <a href="${url_userInfo}">your profile</a></p>
                        <p> Or you can go <a href="${url_userScores}">here</a> to check top 10 best scores</p>
                    </div>  

                </div>

            </div>

        </div>

        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>

    </body>

</html>





