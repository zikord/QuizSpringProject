<%-- 
    Document   : index1
    Created on : Aug 1, 2018, 4:45:33 PM
    Author     : Zika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quizes</title>
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
                        <li class="breadcrumb-item active">Quizes</li>
                    </ol> 

                    <div class="breadcrumb">
                        <a class="btn btn-success breadcrumb-item" id="createQuizModal" data-toggle="modal" href="#createQuiz"><i class="fas fa-plus"></i> New Quiz</a></br>
                    </div>

                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Quizes</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="quizTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>About</th>
                                            <th>Date Created</th>
                                            <th>Date Modified</th>                                            
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>About</th>
                                            <th>Date Created</th>
                                            <th>Date Modified</th>                                            
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="q" items="${quizList}" varStatus="st">
                                            <tr id="${q.id}">
                                                <td>${q.id}</td>
                                                <td>${q.name}</td>
                                                <td>${q.about}</td>
                                                <td>${q.createdDate}</td>
                                                <td>${q.modifiedDate}</td>  
                                                <td><a class="btn btn-info btn-block" id="editQuizModal" data-id="${q.id}" data-name="${q.name}" data-about="${q.about}" data-toggle="modal" href="#editQuiz">
                                                        <i class="fas fa-edit"></i></a></td>
                                                <td><a class="btn btn-danger btn-block" id="deleteQuizModal" data-id="${q.id}" data-name="${q.name}" data-toggle="modal" href="#deleteQuiz">
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

        <!-- Create quiz modal -->
        <div class="modal fade" id="createQuiz" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="lineModalLabel">Create new Quiz</h3>
                        <a data-dismiss="modal" onmouseover="" style="cursor: pointer;"><i class="fas fa-times"></i></a> 
                    </div>
                    <div class="modal-body">
                        <!-- content goes here -->
                        <form id="createQuizForm">
                            <hidden id="createdQuizId" name="createdQuizId" value="0"></hidden>
                            <div class="form-group">
                                <label for="name">Quiz Name</label>
                                <input type="text" class="form-control quizInput" id="quizName" name="name" required="required" placeholder="Enter Quiz name here">
                            </div>
                            <div class="form-group">
                                <label for="about">About</label>
                                <input type="text" class="form-control quizInput" id="quizAbout" name="about" required="required" placeholder="Enter short description about quiz">
                            </div>
                            <div id="addQuestion" class="addQuestionAnswers">
                                <div class="form-group">
                                    <label>Question Title</label>
                                    <input type="text" class="form-control" id="createQuestionTitle" name="title" required="required" placeholder="Enter quiz title, example 'First question', 'Sport question' etc...">
                                </div>
                                <div class="form-group">
                                    <label>Question Text</label>
                                    <input type="text" class="form-control" id="createQuestionText" name="text" required="required" placeholder="Question text">
                                </div>
                                <div class="form-group createAnswer">
                                    <label>Answer Text 1</label>
                                    <input type="text" class="form-control ansText" name="ansText" required="required"  placeholder="Answer option 1">
                                    <label>Correct Answer</label>
                                    <input type="radio"  id="createRadio1" name="ansCorrect" onmouseover="" style="cursor: pointer" required="required">
                                </div>
                                <div class="form-group createAnswer">
                                    <label>Answer Text 2</label>
                                    <input type="text" class="form-control ansText" name="ansText" required="required" placeholder="Answer option 2">
                                    <label>Correct Answer</label>
                                    <input type="radio" id="createRadio2" name="ansCorrect" onmouseover="" style="cursor: pointer" required="required" >
                                </div>
                                <div id="addedAnswers">
                                </div>
                            </div>
                            </br>
                            <button  type="button" class="btn btn-info btn-sm" id="addAnswer"><i class="fas fa-plus"></i> Add New Answer</button>
                            <button  type="button" class="btn btn-info btn-sm" id="removeAnswer"><i class="fas fa-minus"></i> Remove Answer</button>
                            <button type="submit" class="btn btn-info btn-sm" id="saveQuiz" data-action="save"><i class="fas fa-plus"></i> Add Question</button>
                        </form>

                    </div>

                </div>
            </div>
        </div>


        <!--delete quiz modal form -->
        <div class="modal fade" id="deleteQuiz" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">          
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <label class="modal-title" for="modalQuizName"></label>                   
                    </div>
                    <div class="modal-body">
                        <!-- content goes here -->
                            <hidden name="deleteQuizId" id="deleteQuizId" val=""></hidden>
                            <button type="button" id="deleteQuizButton" class="btn btn-success btn-lg"><i class="fas fa-check"></i></button>                               
                            <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal"  role="button"><i class="fas fa-times"></i></button>
                    </div>
                </div>
            </div>
        </div>


        <!--edit quiz modal form -->
        <div class="modal fade" id="editQuiz" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="lineModalLabel">Edit Quiz</h3>
                    </div>
                    <div class="modal-body">

                        <!-- content goes here -->
                        <form>
                            <hidden name="editQuizId" id="editQuizId" val=""></hidden>
                            <div class="form-group">
                                <label for="editQuizName">Name</label>
                                <input type="text" class="form-control" id="editQuizName" name="editQuizName" required="required" placeholder="Quez name is required">
                            </div>
                            <div class="form-group">
                                <label for="editAbout">About</label>
                                <input type="text" class="form-control" id="editQuizAbout" required="required" name="editQuizAbout" placeholder="Question description is required">
                            </div>
                            <div id="changeEditQuestions" class="editQuestionsAnswers">                               
                            </div>
                            </br>
                            <button type="button" class="btn btn-info btn-sm" id="editQuestions"><i class="fas fa-edit"></i> Edit Questions</button>
                            <button type="button" class="btn btn-info btn-sm editQuestionsAnswers" id="prevBtn"><i class="fas fa-chevron-left"></i> Previous</button>
                            <button type="button" class="btn btn-info btn-sm editQuestionsAnswers" id="nextBtn"> Next <i class="fas fa-chevron-right"></i></button>

                            <div class="modal-footer">
                                <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                                    <div class="btn-group" role="group">
                                        <button type="submit" class="btn btn-success btn-sm" data-action="save"><i class="far fa-save"></i> Save</button>   
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
