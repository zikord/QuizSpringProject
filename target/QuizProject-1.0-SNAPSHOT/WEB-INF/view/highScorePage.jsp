<%-- 
    Document   : highScorePage
    Created on : Feb 16, 2019, 6:04:08 PM
    Author     : Zika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HighScores</title>
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
                        <li class="breadcrumb-item active">Highscores Screen</li>
                    </ol>

                    <!-- Icon Cards-->
                    <button type="button" class="btn btn-success btn-sm" id="prevQuiz"><i class="fas fa-chevron-left"></i> Previous Quiz</button>
                    <button type="button" class="btn btn-success btn-sm" id="nextQuiz">Next Quiz <i class="fas fa-chevron-right"></i></button>
                    <c:forEach items="${sws}" var="sw" varStatus="s"> 
                        <div class="scoreWrapper">
                            <div class="jumbotron">
                                <h1>TOP 10 SCORES</h1></br>
                                <p>Quiz name :  <span class="boldText">${sw.quiz.name}</span></p></br>
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
        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>
    </body>
</html>

