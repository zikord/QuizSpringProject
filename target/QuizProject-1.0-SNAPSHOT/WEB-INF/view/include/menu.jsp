<%-- 
    Document   : menu2
    Created on : Aug 2, 2018, 2:29:42 PM
    Author     : Zika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:url var="url_logout" value="/logout"/> 

<%-- User url --%>
<s:url var="url_userHome" value="/user/home"/>
<s:url var="url_userInfo" value="/user/info"/>
<s:url var="url_userScores" value="/user/highscores"/>
<s:url var="url_userAbout" value="/user/about"/>


<%-- Admin url--%>
<s:url var="url_aHome" value="/admin/dashboard"/>
<s:url var="url_admin_quiz_list" value="/admin/quizList"/>
<s:url var="url_admin_user_list" value="/admin/userList"/>
<s:url var="url_create_quiz" value="/admin/create_quiz"/>
<s:url var="url_edit_quizes" value="/admin/editQuizes"/>




<!-- User Sidebar -->

<c:if test="${sessionScope.userId!=null && sessionScope.role == 0}">

    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="${url_userHome}">
                <i class="fas fa-fw fa-home"></i>
                <span>Home Page</span>
            </a>
        <li class="nav-item">
            <a class="nav-link" href="${url_userInfo}">
                <i class="fas fa-user-circle fa-fw"></i>
                <span>User Info</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${url_userScores}">
                <i class="fas fa-fw fa-list"></i>
                <span>High Scores</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${url_userAbout}">
                <i class="fas fa-fw fa-info"></i>
                <span>About</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${url_logout}">
                <i class="fas fa-fw fa-user-times"></i>
                <span>Logout</span></a>
        </li>
    </ul>

</c:if>

<!-- Admin Sidebar -->

<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">

    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="${url_aHome}">
                <i class="fas fa-fw fa-home"></i>
                <span>Admin Home Page</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${url_admin_user_list}">
                <i class="fas fa-users fa-fw"></i>
                <span>Users List</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${url_admin_quiz_list}">
                <i class="fas fa-fw fa-table"></i>
                <span>Quizes</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${url_logout}">
                <i class="fas fa-fw fa-user-times"></i>
                <span>Logout</span></a>
        </li>
    </ul>      
</c:if>