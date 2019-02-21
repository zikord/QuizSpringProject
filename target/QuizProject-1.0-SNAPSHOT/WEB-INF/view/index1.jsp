<%-- 
    Document   : index1
    Created on : Aug 1, 2018, 4:45:33 PM
    Author     : Zika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring project</title>

        <jsp:include page="include/css.jsp"/>

    </head>

    <body id="page-top" class="index">

        <jsp:include page="include/header.jsp"/>




        <div id="wrapper">


            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Welcome</a>
                        </li>
                        <li class="breadcrumb-item active">Login and Registration</li>
                        <c:if test="${successMsg != null}"><li class="breadcrumb-item tmpMsg" style="color: green">${successMsg}</li></c:if>
                        <c:if test="${errorMsg != null}"><li class="breadcrumb-item tmpMsg" style="color: red">${errorMsg}</li></c:if>
                        </ol>
                        
                        <!-- Icon Cards-->  
                        <div class="row">
                            <div class="col-xl-3 col-sm-6 mb-3" >
                                <div class="card text-white bg-primary o-hidden h-100" >
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fas fa-fw fa-user-circle"></i>
                                        </div>
                                        <div class="mr-5">LOGIN</div>
                                    </div>
                                    <a class="card-footer text-white clearfix small z-1" href="#loginModal" id="loginButton" data-toggle="modal">
                                        <span class="float-left">SELECT</span>
                                        <span class="float-right">
                                            <i class="fas fa-angle-right"></i>
                                        </span>
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-3 col-sm-6 mb-3">
                                <div class="card text-white bg-success o-hidden h-100">
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fas fa-fw fa-user-circle"></i>
                                        </div>
                                        <div class="mr-5">SING UP</div>
                                    </div>
                                    <a class="card-footer text-white clearfix small z-1" href="#signUpModal" data-toggle="modal">
                                        <span class="float-left">SELECT</span>
                                        <span class="float-right">
                                            <i class="fas fa-angle-right"></i>
                                        </span>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h3 class="modal-title">Login</h3>
                                        <a data-dismiss="modal" onmouseover="" style="cursor: pointer;"><i class="fas fa-times"></i></a>
                                    </div>
                                    <div class="modal-body">
                                    <s:url var="url_login" value="/login"/>
                                    <f:form action="${url_login}" modelAttribute="command">
                                        <div class="form-group">
                                            <div class="form-label-group">
                                                <input required type="text" name="username" id="username" class="form-control" placeholder="Username" autofocus="autofocus">
                                                <label for="username">Username</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-label-group">
                                                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="required">
                                                <label for="password">Password</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" value="remember-me">
                                                    Remember Password
                                                </label>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary btn-block">Login</button>
                                    </f:form>
                                    <div class="text-center">
                                        <a class="p-2" href="#signUpModal" data-dismiss="modal" data-toggle="modal">Register an Account</a></br>
                                        <a class="p-2" href="#forgotPasswordModal" data-dismiss="modal" data-toggle="modal">Forgot Password?</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="signUpModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h3 class="modal-title">Register an Account</h3>
                                    <a data-dismiss="modal" onmouseover="" style="cursor: pointer;"><i class="fas fa-times"></i></a>
                                </div>
                                <div class="modal-body">
                                    <s:url var="url_reg" value="/register"/>
                                    <f:form action="${url_reg}" modelAttribute="command1">
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-label-group">
                                                        <input type="text" id="name" name="name" class="form-control" placeholder="First name" required="required" autofocus="autofocus">
                                                        <label for="name">Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-label-group">
                                                        <input type="text" id="regUsername" name="username" class="form-control" placeholder="Username" required="required">
                                                        <label for="regUsername">Username</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-label-group">
                                                        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
                                                        <label for="inputPassword">Password</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-label-group">
                                                        <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                                                        <label for="confirmPassword">Confirm password</label>
                                                        <span id="message"></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary btn-block" id="regBtn">Register</button>
                                    </f:form>
                                    <div class="text-center">
                                        <a class="p-2" href="#loginModal" data-dismiss="modal" data-toggle="modal">Login Page</a></br>
                                        <a class="p-2" href="#forgotPasswordModal" data-dismiss="modal" data-toggle="modal">Forgot Password?</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="forgotPasswordModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">         
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h3 class="modal-title">Reset Password</h3>
                                    <a data-dismiss="modal" onmouseover="" style="cursor: pointer;"><i class="fas fa-times"></i></a>
                                </div>
                                <div class="modal-body">
                                    <div class="text-center mb-4">
                                        <h4>Forgot your password?</h4>
                                        <p>Enter your email address and we will send you instructions on how to reset your password.</p>
                                    </div>
                                    <form>
                                        <div class="form-group">
                                            <div class="form-label-group">
                                                <input type="email" id="inputEmail" class="form-control" placeholder="Enter email address" required="required" autofocus="autofocus">
                                                <label for="inputEmail">Enter email address</label>
                                            </div>
                                        </div>
                                        <a class="btn btn-primary btn-block showLogin" href="#">Reset Password</a>
                                    </form>
                                    <div class="text-center">
                                        <a class="p-2" href="#signUpModal" data-dismiss="modal" data-toggle="modal">Register an Account</a></br>
                                        <a class="p-2" href="#loginModal" data-dismiss="modal" data-toggle="modal">Login Page</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>

    </body>
</html>
