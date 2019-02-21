/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.dao;

import com.link.quizproject.domain.Answer;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public interface AnswerDAO extends EntityDAO<Answer>{
    
    public ArrayList<Answer> getAnswersByQuestionId(Integer id);
    
    
    
}
