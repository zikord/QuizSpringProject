/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.dao;

import com.link.quizproject.domain.Answer;
import com.link.quizproject.domain.Question;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public interface QuestionDAO extends EntityDAO<Question>{
    
    public ArrayList<Answer> loadPossibleAnswer(Question q);  
    
    public ArrayList<Question> findQuestionByQuizId (Integer id);
    
}
