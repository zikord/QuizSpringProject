/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.service;

import com.link.quizproject.dao.BaseDAO;
import com.link.quizproject.dao.QuizDAO;
import com.link.quizproject.domain.Game;
import com.link.quizproject.domain.Question;
import com.link.quizproject.domain.Quiz;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zika
 */
@Service
public class QuizServiceImpl extends BaseDAO implements QuizService {

    @Autowired
    private QuizDAO quizDAO;

    @Autowired
    private QuestionService questionService;

    @Override
    public int createQuiz(Quiz q) {
        try {
            this.quizDAO.save(q);
        } catch (SQLException ex) {
            Logger.getLogger(QuizServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return q.getId();
    }

    @Override
    public List<Quiz> getQuizList() {
        List<Quiz> quizes = quizDAO.findAll();
        return quizes;
    }

    @Override
    public List<Quiz> getQuizListWithQuestions() {
        List<Quiz> quizes = quizDAO.findAll();
        for (Quiz quiz : quizes) {
            loadQuestions(quiz);
            for (Question question : quiz.getQuestions()) {
                questionService.loadPossibleAnswers(question);
            }
        }
        System.out.println(quizes);
        return quizes;
    }

    @Override
    public Quiz getQuizById(Integer id) {
        Quiz quiz = quizDAO.findById(id);
        loadQuestions(quiz);
        for (Question q : quiz.getQuestions()) {
            questionService.loadPossibleAnswers(q);
        }
        return quiz;
    }

    @Override
    public void updateQuiz(Quiz q) {
        this.quizDAO.update(q);
    }

    @Override
    public void deleteQuiz(Integer id) {
        this.quizDAO.delete(id);
    }

    @Override
    public void loadQuestions(Quiz q) {
        ArrayList<Question> que = this.quizDAO.loadQuestions(q);
        q.setQuestions(que);
    }

    @Override
    public void loadGames(Quiz q) {
        ArrayList<Game> game = this.quizDAO.loadGames(q);
        q.setGames(game);
    }

}
