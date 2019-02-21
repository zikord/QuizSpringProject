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
        <title>User Information Page</title>
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
                        <li class="breadcrumb-item active">User Information Screen</li>
                    </ol>

                    <!-- Icon Cards-->
                    <div class="jumbotron">
                        <h1>User Information Page</h1></br>
                        <p>This page contains basic user information and user best scores</p></br>
                        <p>Name: <span class="boldText">${user.name}</span></p>
                        <p>Username:  <span class="boldText">${user.username}</span></p></br>
                        <button class="btn btn-success" id="toggleUserScores">User best scores</button>
                    </div>


                    <!-- Icon Cards-->
                    <div id="userScores">
                        <button type="button" class="btn btn-success btn-sm" id="prevQuiz"><i class="fas fa-chevron-left"></i> Previous Quiz</button>
                        <button type="button" class="btn btn-success btn-sm" id="nextQuiz">Next Quiz <i class="fas fa-chevron-right"></i></button>
                            <c:forEach items="${sws}" var="sw" varStatus="s">
                            <div class="scoreWrapper">
                                <div class="jumbotron">
                                    <p>TOP 10 PERSONAL SCORES</p>
                                    <p>Quiz name : ${sw.quiz.name}</p></br>
                                </div>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Place</th>
                                                <th>Username</th>
                                                <th>Date</th>                                            
                                                <th>Score</th>                                     
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Place</th>
                                                <th>Username</th>
                                                <th>Date</th>                                            
                                                <th>Score</th>                                       
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach items="${sw.scoresCommand}" var="sc" varStatus="st">
                                                <tr>
                                                    <th>${st.count}</th>
                                                    <th>${sc.username}</th>
                                                    <th>${sc.endTime}</th>                                            
                                                    <th>${sc.score}</th>                                           
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>   
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </div>

        </div>
        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>
    </body>
</html>
