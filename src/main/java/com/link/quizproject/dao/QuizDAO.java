/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.dao;

import com.link.quizproject.domain.Game;
import com.link.quizproject.domain.Question;
import com.link.quizproject.domain.Quiz;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public interface QuizDAO extends EntityDAO<Quiz>{
    
    public abstract ArrayList<Question> loadQuestions(Quiz q);
    
    public abstract ArrayList<Game> loadGames(Quiz q);
    
    
}
