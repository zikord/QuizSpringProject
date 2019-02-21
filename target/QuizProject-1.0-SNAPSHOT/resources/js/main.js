
$(function toggleTip() {
    $('[data-toggle="tooltip"]').tooltip();
});

$(function () {
    $(".quizStart").click(function () {
        $("#quizes").load('quiz.jsp');
    });
});

function indexPageOnly() {
    $(".sticky-footer").css("width", "100%");
}
;

if ($('body.index').length) {
    indexPageOnly();
    $("#userDropdown").css("display", "none");
}

$(function () {
    $('#inputPassword, #confirmPassword').on('keyup', function () {
        if ($('#inputPassword').val() === $('#confirmPassword').val()) {
            $('#message').html('Matching').css('color', 'green');
            $('#regBtn').removeAttr('disabled', 'disabled');
        } else {
            $('#message').html('Not Matching').css('color', 'red');
            $('#regBtn').attr('disabled', 'disabled');
        }
    });
});

setTimeout(function () {
    $('.tmpMsg').remove();
}, 3000);
/************************************************************
 JQUERY FOR SHOWING NEXT QUIZ QUESTION
 ************************************************************/
$(function () {

    var currQuestion = 1;
    $('#btnNext').on('click', function () {

        currQuestion++;
        var currDiv = $(".qList:visible");
        var nextDiv = currDiv.next(".qList");
        if (currQuestion === $(".qList").length) {
            $("#btnNext").hide();
            $("#btnSubmit").show();
        }

        currDiv.hide();
        nextDiv.show();
    });
});


/************************************************************
 FILL EDIT USER FORM IN MODAL WITH DATA
 ************************************************************/
$(function () {
    $('#editUser').on('show.bs.modal', function (e) {
        $("#successMsg").hide();
        var userId = $(e.relatedTarget).data('id');
        var userName = $(e.relatedTarget).data('name');
        var userUsername = $(e.relatedTarget).data('username');
        var userRole = $(e.relatedTarget).data('role');
        $(e.currentTarget).find('input[name="editName"]').val(userName);
        $(e.currentTarget).find('input[name="editUsername"]').val(userUsername);
        $(e.currentTarget).find('select').val(userRole);
        $(e.currentTarget).find('hidden[name="editUserId"]').val(userId);
    });
});


/************************************************************
 SUBMIT EDIT USER FORM WITH AJAX POST REQUEST
 ************************************************************/
$("#editForm").submit(function (e) {

    e.preventDefault();

    var formData = {
        id: $("#editUserId").val(),
        name: $("#editName").val(),
        username: $("#editUsername").val(),
        role: $("#editRole").val()
    };

    var dataJson = JSON.stringify(formData);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "../admin/editUser",
        data: dataJson,
        success: function () {
            $("#successMsg").show();
            $("#userTable").load(location.href + " #userTable");
        },
        error: function (e) {
            $("#errorMsg").show();
            console.log(e);
        }
    });
});

/************************************************************
 DELETE USER MODAL
 ************************************************************/
$(function () {
    $("#deleteUser").on("show.bs.modal", function (e) {

        var userId = $(e.relatedTarget).data('id');
        var userName = "Are you sure you want to delete User : " + $(e.relatedTarget).data('name');
        $(e.currentTarget).find('label[for="modalUserName"]').text(userName);
        $(e.currentTarget).find('hidden[name="modalUserId"]').val(userId);
        console.log(userId);
    });
});

/************************************************************
 DELETE USER WITH AJAX
 ************************************************************/
$("#deleteUserButton").on('click', function () {

    var userId = $("#modalUserId").val();

    var table = $("#userTable").DataTable();

    var button = $("#" + userId);

    console.log(button);

    $.ajax({
        type: "POST",
        url: "../admin/userDel",
        data: {id: userId},
        success: function () {
            table.row(button).remove().draw();
            $("#deleteUser").modal('hide');
        },
        error: function (e) {
            alert("error" + userId);
        }
    });
});

/************************************************************
 FILL EDIT QUIZ MODAL WITH DATA
 ************************************************************/
var editData;
$(function editQuizModalData() {
    $('#editQuiz').on('show.bs.modal', function (e) {

        $('.editQuestionsAnswers').hide();
        var quizId = $(e.relatedTarget).data('id');
        var quizName = $(e.relatedTarget).data('name');
        var quizAbout = $(e.relatedTarget).data('about');
        $.ajax({
            type: "GET",
            url: "../admin/quizEdit?quizId=" + quizId,
            dataType: 'json',
            success: function (data) {
                $(e.currentTarget).find('input[name="editQuizName"]').val(quizName);
                $(e.currentTarget).find('input[name="editQuizAbout"]').val(quizAbout);
                $(e.currentTarget).find('hidden[name="editQuizId"]').val(quizId);
                var ans;
                var div;
                var num = 1;
                var radios;
                $.each(data, function (i, question) {
                    div = $('<div class="editList" />')
                            .append($('<label for="editQuestionTitle">Question Title</label>'))
                            .append($('<input type="text" class="form-control" required="required" placeholder="Question title is required"/></br>').prop('value', question.title).prop('name', "editQuestionTitle" + question.id))
                            .append($('<label for="editQuestion">Question number' + ' ' + num++ + '</label>'))
                            .append($('<input type="text" class="form-control" required="required" placeholder="Question text is required"/></br>').prop('value', question.text).prop('name', "editQuestionText" + question.id))
                            .append($('<label for="editAnswer">Answers</label>'));
                    $.each(question.answers, function (index, answers) {
                        ans = $('<div/>')
                                .append($('</br><input type="text" class="form-control" required="required" placeholder="Answer is required"/>').prop('value', answers.text).prop("name", "editAnswerText" + answers.id))
                                .append($('<label>Correct Answer</label><input type="radio" onmouseover="" style="cursor: pointer"/></br>').prop('value', answers.correct).prop('name', "correct" + answers.question_id).prop('id', 'ans' + answers.id));
                        div.append(ans);
                    });
                    $('#changeEditQuestions').append(div);
                });
                $('input[name^=correct][value=1]').prop('checked', true);
                editData = data;
            }
        });
    });
});
/************************************************************
 FUNCTION FOR SUBMITING EDIT QUIZ FORM WITH AJAX REQUEST
 ************************************************************/
$("#editQuiz").submit(function (e) {

    e.preventDefault();

    var quiz = {
        id: $("#editQuizId").val(),
        name: $("#editQuizName").val(),
        about: $("#editQuizAbout").val()
    };

    var checkedRadios = [];
    var questions = [];
    var answers = [];
    $.each(editData, function (i, q) {
        questions.push({
            id: q.id,
            title: ($('input[name=editQuestionTitle' + q.id + ']').val()),
            text: ($('input[name=editQuestionText' + q.id + ']').val()),
            quiz_id: q.quiz_id
        });
        $.each(q.answers, function (index, a) {
            answers.push({
                id: a.id,
                text: ($('input[name=editAnswerText' + a.id + ']').val()),
                correct: ($('input[id=ans' + a.id + ']').filter(':checked').prop('value', 1).val()), // :)
                question_id: a.question_id
            });
        });
    });
    var editedData = {
        quiz: quiz,
        questions: questions,
        answers: answers
    };
    console.log(answers);
    var json = JSON.stringify(editedData);
    $.post({
        url: 'editQuiz',
        contentType: 'application/json; charset=utf-8',
        data: json,
        success: function (response) {
            $("#editQuiz").modal('hide');
            $("#quizTable").load(" #quizTable");
            console.log("good");
        },
        error: function (e) {
            console.log("fail");
            console.log(e);
        }
    });
});
/************************************************************
 CLEAR DATA FOR EDIT QUIZ AFTER MODAL IS CLOSED
 ************************************************************/
$('#editQuiz').on('hidden.bs.modal', function () {
    $("#changeEditQuestions").html("");
});
/***********************************
 TOGGLE EDIT QUESTIONS FORM IN MODAL
 ***********************************/
$('#editQuestions').click(function () {
    $('.editQuestionsAnswers').toggle();
});
/************************************************************
 ITERATE WITH BUTTONS THROUGH EDIT QUIZ QUESTIONS AND ANSWERS
 ************************************************************/
$(function () {

    var currQuestion = 1;
    $('#nextBtn').on('click', function () {

        currQuestion++;
        var currDiv = $(".editList:visible");
        var nextDiv = currDiv.next(".editList");
        if (nextDiv.length === 0) {
            nextDiv = $(".editList:first");
        }
        currDiv.hide();
        nextDiv.show();
    });
    $('#prevBtn').on('click', function () {

        currQuestion--;
        var currDiv = $(".editList:visible");
        var prevDiv = currDiv.prev(".editList");
        if (prevDiv.length === 0) {
            prevDiv = $(".editList:last");
        }

        currDiv.hide();
        prevDiv.show();
    });
});
/**********************
 OPEN DELETE QUIZ MODAL
 **********************/
$(function () {
    $("#deleteQuiz").on("show.bs.modal", function (e) {

        var quizName = "Are you sure you want to delete Quiz : " + $(e.relatedTarget).data('name');
        $(e.currentTarget).find('label[for="modalQuizName"]').text(quizName);
        var quizId = $(e.relatedTarget).data('id');
        $(e.currentTarget).find('hidden[name="deleteQuizId"]').val(quizId);
        console.log(quizId);
    });
});
/**********************
 DELETE QUIZ WITH AJAX 
 **********************/
$("#deleteQuizButton").on('click', function () {

    var quizId = $("#deleteQuizId").val();
    
    var table = $("#quizTable").DataTable();
    
    var button = $("#" + quizId);

    $.ajax({
        type: "POST",
        url: "../admin/quizDel",
        data: {id: quizId},
        success: function () {
            table.row(button).remove().draw();
            $("#deleteQuiz").modal('hide');
        },
        error: function (e) {
            alert("error" + quizId);
            console.log(quizId);
        }
    });
});
/*************************
 ADD ANSWER INPUT IN MODAL
 *************************/
$(function () {

    var counter = 3;
    $("#addAnswer").click(function () {

        // CLEAR MODAL AFTER CLOSING //
        $('#createQuiz').on('hidden.bs.modal', function () {
            counter = 3;
        });
        if (counter > 6) {
            alert("Maximum 6 answers allowed");
            return false;
        }
        ;
        if (counter > 2) {
            $("#removeAnswer").show();
        }
        ;
        var newAnswerDiv = $(document.createElement('div'))
                .attr("id", 'answerDiv' + counter);
        newAnswerDiv.after().html('<label>Answer Text ' + counter + '</label>' +
                '<input type="text" name="ansText" class="form-control ansText" required="required" placeholder="Answer option ' + counter + '">' +
                '<label>Correct Answer</label>' +
                '<input type="radio" id="createRadio' + counter + '"  name="ansCorrect" onmouseover="" style="cursor: pointer"/>' + '<br></br>');
        newAnswerDiv.appendTo("#addedAnswers");
        counter++;
    });
    $("#removeAnswer").click(function () {
        if (counter <= 4) {
            $("#removeAnswer").hide();
        }
        ;
        counter--;
        $("#answerDiv" + counter).remove();
    });
});
/**********************
 CREATE QUIZ USING AJAX
 **********************/
$(function () {
    $('#createQuizForm').on('submit', function (e) {
        e.preventDefault();
        var answers = [];
        $('input.ansText').each(function () {
            answers.push({
                text: $(this).val(),
                correct: ($(this).siblings(':checked').prop('value', 1).val())
            });
        });
        var data = {
            quiz: {
                id: $('hidden[name=createdQuizId]').val(),
                name: $('input[name=name]').val(),
                about: $('input[name=about]').val()
            },
            question: {
                title: $('input[name=title]').val(),
                text: $('input[name=text]').val()
            },
            answers
        };
        console.log(answers);
        var json = JSON.stringify(data);
        $.post({
            url: 'createQuiz',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: json,
            success: function (response) {
                $("#createQuizForm").trigger("reset");
                $("#createdQuizId").val(response.id);
                $("#quizName").replaceWith("<div id='quizLabelName'>" + response.name + "</div>");
                $("#quizAbout").replaceWith("<div id='quizLabelAbout'>" + response.about + "</div>");
                $("#quizTable").load(" #quizTable");
            },
            error: function (e) {
                alert("fail");
            }
        });
    });
});
/*************************************
 CLEAR CREATE QUIZ MODAL AFTER CLOSING
 *************************************/
$(function () {
    $("#createQuizModal").on('click', function () {
        $("#createQuizForm").trigger('reset');
        $("#addedAnswers").html("");
        $("#removeAnswer").hide();
        $("#quizLabelName").replaceWith("<input type='text' class='form-control' id='quizName' name='name'>");
        $("#quizLabelAbout").replaceWith("<input type='text' class='form-control' id='quizAbout' name='about'>");
        $("#createdQuizId").val(0);
    });
});


/*************************************
 ITERATE THROUGH HIGHSCORE TABLES
 *************************************/
$(function () {

    var currTable = 1;
    $('#nextQuiz').on('click', function () {

        currTable++;
        var currDiv = $(".scoreWrapper:visible");
        var nextDiv = currDiv.next(".scoreWrapper");
        if (nextDiv.length === 0) {
            nextDiv = $(".scoreWrapper:first");
        }
        currDiv.hide();
        nextDiv.show();
    });
    $('#prevQuiz').on('click', function () {

        currTable--;
        var currDiv = $(".scoreWrapper:visible");
        var prevDiv = currDiv.prev(".scoreWrapper");
        if (prevDiv.length === 0) {
            prevDiv = $(".scoreWrapper:last");
        }
        currDiv.hide();
        prevDiv.show();
    });
});

/*************************************
 TOGGLE USER HIGHSCORE TABLES
 *************************************/
$(function () {
    $("#toggleUserScores").on('click', function () {
        $("#userScores").toggle();
    });
});
