<%-- 
    Document   : index1
    Created on : Aug 1, 2018, 4:45:33 PM
    Author     : Zika
--%>

<!DOCTYPE html>
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


    <body id="page-top">


        <jsp:include page="include/header.jsp"/>

        <div id="wrapper">


            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">${user.name}</a>
                        </li>
                        <li class="breadcrumb-item active"><c:out value='${cmd.quiz.name}' /></li>
                    </ol>

                    <!-- Questions and answers -->

                    <s:url var="url_processQuiz" value="/user/processQuiz"/>                                         
                    <f:form action="${url_processQuiz}" method="POST" modelAttribute="cmd">
                        <c:forEach var="q" items="${cmd.questions}" varStatus="st">
                            <div class="qList">
                                <div class="jumbotron">
                                    <f:input type="hidden" path="questions[${st.index}].id"/>
                                    <h1 class="display-4">${q.text}</h1>
                                    <hr class="my-4">
                                    <c:forEach var="a" items="${q.answers}">
                                        <label class="container">
                                            <f:radiobutton  label="${a.text}" path="answers[${st.index}].id" value="${a.id}" required="required"></f:radiobutton></br>                       
                                                <span class="checkmark"></span>
                                            </label>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:forEach>
                        <a class="btn btn-primary btn-lg btn-block" id="btnNext" href="#" >Next</a>
                        <button class="btn btn-primary btn-lg btn-block" id="btnSubmit">Submit</button>
                    </f:form> 

                </div>
            </div>
        </div>
        <jsp:include page="include/footerQuiz.jsp"/>

        <jsp:include page="include/js.jsp"/>

    </body>
</html>
