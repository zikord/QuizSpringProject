<%-- 
    Document   : index1
    Created on : Aug 1, 2018, 4:45:33 PM
    Author     : Zika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
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
                        <li class="breadcrumb-item active">Home Screen</li>
                    </ol>

                    <!-- Icon Cards-->

                    <div class="row">
                        <c:forEach var="q" items="${quizList}" varStatus="st">
                            <div class="col-xl-3 col-sm-6 mb-3" id="quizes">
                                <div class="card text-white bg-primary o-hidden h-100" data-toggle="tooltip" data-placement="top" title="${q.about}" >
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fas fa-fw"></i>
                                        </div>
                                        <div class="mr-5">${q.name}</div>
                                    </div>
                                    <s:url var="url_start" value="/user/quizStart">
                                        <s:param name="id" value="${q.id}"/>
                                    </s:url>
                                    <a class="card-footer text-white clearfix small z-1 quizStart" href="${url_start}">
                                        <span class="float-left">START</span>
                                        <span class="float-right">
                                            <i class="fas fa-angle-right"></i>
                                        </span>
                                    </a>
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
