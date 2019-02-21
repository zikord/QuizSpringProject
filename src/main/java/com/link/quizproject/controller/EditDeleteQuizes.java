/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.controller;

import com.link.quizproject.command.QuizFormCommand;
import com.link.quizproject.domain.Question;
import com.link.quizproject.domain.Quiz;
import com.link.quizproject.service.AnswerService;
import com.link.quizproject.service.QuestionService;
import com.link.quizproject.service.QuizService;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Zika
 */
@Controller
public class EditDeleteQuizes {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "admin/quizList", method = RequestMethod.GET)
    public String adminQuizList(Model m, HttpSession session) {
        ArrayList<Quiz> quizes = (ArrayList<Quiz>) quizService.getQuizList();
        m.addAttribute("quizList", quizes);
        return "quizListAdmin"; // JSP view
    }

    @RequestMapping(value = "admin/quizDel", method = RequestMethod.POST)
    public @ResponseBody
    void deleteQuiz(@RequestParam Integer id) {
        try {
            System.out.println(id);
            quizService.deleteQuiz(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "admin/quizEdit", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> editQuizForm(@RequestParam("quizId") Integer id) {
        ArrayList<Question> questions = (ArrayList<Question>) questionService.questionsInQuiz(id);
        return questions;
    }

    @RequestMapping(value = "admin/editQuiz", method = RequestMethod.POST)
    @ResponseBody
    public void handleEditQuiz(@RequestBody QuizFormCommand cmd) {
        try {
            quizService.updateQuiz(cmd.getQuiz());
            questionService.updateQuestions(cmd.getQuestions());
            answerService.updateAnswers(cmd.getAnswers());
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
        }
    }
}