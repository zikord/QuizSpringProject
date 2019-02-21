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
        <title>Users List</title>
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
                        <li class="breadcrumb-item active">Users List</li>
                    </ol>

                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Users List</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="userTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Username</th>
                                            <th>Role</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Username</th>
                                            <th>Role</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="u" items="${userList}" varStatus="st">
                                            <tr id="${u.id}">
                                                <td>${u.id}</td>
                                                <td>${u.name}</td>
                                                <td>${u.username}</td>
                                                <td>${u.role}</td>
                                                <td><a class="btn btn-info btn-block" id="modalId" data-id="${u.id}" data-name="${u.name}" data-username="${u.username}" data-role="${u.role}" data-toggle="modal" href="#editUser" >
                                                        <i class="fas fa-edit"></i></a></td> 
                                                <td><a class="btn btn-danger btn-block" id="deleteUserId" data-id="${u.id}" data-name="${u.name}" data-toggle="modal" href="#deleteUser">
                                                        <i class="fas fa-trash-alt"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        
        <!--delete user modal form -->
        <div class="modal fade" id="deleteUser" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">          
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <label class="modal-title" for="modalUserName"></label>                   
                    </div>
                    <div class="modal-body">
                            <hidden name="modalUserId" id="modalUserId" val=""></hidden>
                            <button type="button" id="deleteUserButton" class="btn btn-success btn-lg"><i class="fas fa-check"></i></button>                               
                            <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal"  role="button"><i class="fas fa-times"></i></button>
                    </div>
                </div>
            </div>
        </div>


        <!--edit user modal form -->
        <div class="modal fade" id="editUser" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">          
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="lineModalLabel">Edit User Info</h3>                   
                    </div>
                    <div class="modal-body">
                        <!-- content goes here -->
                        <form id="editForm">   
                            <hidden name="editUserId" id="editUserId" val=""></hidden>
                            <span id="successMsg">Edit completed</span>
                            <span id="errorMsg">Edit incomplete, please try again later</span>
                            <div class="form-group">
                                <label for="editName">Name</label>
                                <input type="text" class="form-control" name="editName" id="editName" required="required">
                            </div>
                            <div class="form-group">
                                <label for="editUsername">Username</label>
                                <input type="text" class="form-control" name="editUsername" id="editUsername" required="required">
                            </div>
                            <div class="form-group">
                                <label for="editRole">Role</label>
                                <select id="editRole">
                                    <option value="0">User</option>
                                    <option value="1">Admin</option>
                                </select>
                            </div>                           
                            <div class="modal-footer">
                                <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                                    <div class="btn-group" role="group">
                                        <button type="submit" class="btn btn-success btn-sm"><i class="far fa-save"></i> Save</button>                               
                                    </div>
                                    <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal"  role="button"><i class="far fa-window-close"></i> Close</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>                  
                </div>
            </div>
        </div>

        <jsp:include page="include/footer.jsp"/>

        <jsp:include page="include/js.jsp"/>
    </body>
</html>
