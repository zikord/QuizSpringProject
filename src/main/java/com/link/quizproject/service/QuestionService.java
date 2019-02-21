/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.service;

import com.link.quizproject.domain.Question;
import java.util.List;

/**
 *
 * @author Zika
 */
public interface QuestionService {
    
    public int createQuestion(Question q);
    
    public List<Question> getQuestionsList();
    
    public Question getQuestionById (int id);
    
    public void loadPossibleAnswers(Question q);
    
    public void updateQuestion(Question q);
    
    public void deleteQuestion(int id);
    
    public void updateQuestions(List<Question> questions);
    
    public List<Question> questionsInQuiz(int id);
    
}
