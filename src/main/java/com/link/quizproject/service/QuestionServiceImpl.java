/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.service;

import com.link.quizproject.dao.BaseDAO;
import com.link.quizproject.dao.QuestionDAO;
import com.link.quizproject.domain.Answer;
import com.link.quizproject.domain.Question;
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
public class QuestionServiceImpl extends BaseDAO implements QuestionService{
    
    @Autowired
    private QuestionDAO questionDAO;
            
    @Override
    public int createQuestion(Question q) {
        try {
            this.questionDAO.save(q);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return q.getId();
    }

    @Override
    public ArrayList<Question> getQuestionsList() {
        ArrayList<Question> question = this.questionDAO.findAll();
        return question;
    }

    @Override
    public Question getQuestionById(int id) {
        Question question = this.questionDAO.findById(id);
        ArrayList<Answer> a = this.questionDAO.loadPossibleAnswer(question);
        return question;
    }

    @Override
    public void loadPossibleAnswers(Question q) {
         ArrayList<Answer> a = this.questionDAO.loadPossibleAnswer(q);
         q.setAnswers(a);
    }

    @Override
    public void updateQuestion(Question q) {
        this.questionDAO.update(q);
    }

    @Override
    public void deleteQuestion(int id) {
        this.questionDAO.delete(id);
    }

    @Override
    public ArrayList<Question> questionsInQuiz(int id) {
        ArrayList<Question> questions = this.questionDAO.findQuestionByQuizId(id);
        questions.forEach((quest) -> {
            ArrayList<Answer> a = this.questionDAO.loadPossibleAnswer(quest);
            quest.setAnswers(a);
        });
        return questions;
    }

    @Override
    public void updateQuestions(List<Question> questions) {
        
        questions.forEach((Question question) -> {
            updateQuestion(question);
        });
    }

    
}
