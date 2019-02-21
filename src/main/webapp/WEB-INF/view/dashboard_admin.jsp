<%-- 
    Document   : index1
    Created on : Aug 1, 2018, 4:45:33 PM
    Author     : Zika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home Page</title>
        <jsp:include page="include/css.jsp"/>        
    </head>

    <body>

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
                        <li class="breadcrumb-item active">Administration Home Page</li>
                    </ol>

                    <div class="jumbotron">
                        <h1>Admin Dashboard</h1></br>
                        <span>Welcome ${user.name}</span></br></br>
                        <span>From menu you can select :</span></br> </br>
                        <span>User list - See list of all users in database and from that list you can select to edit or delete user</span></br> </br>
                        <span>Quiz list - See list of all quizes in database and from that list you can select to create, edit or delete quiz</span>
                    </div> 


                    <jsp:include page="include/footer.jsp"/>

                    <jsp:include page="include/js.jsp"/>
                </div>
            </div>
        </div>
    </body>
</html>
