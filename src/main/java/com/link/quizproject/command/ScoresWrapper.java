/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.command;

import com.link.quizproject.domain.Quiz;
import java.util.ArrayList;
/**
 *
 * @author Zika
 */
public class ScoresWrapper {
    
    private ArrayList<ScoresCommand> scoresCommand;
    
    private Quiz quiz;

    public ArrayList<ScoresCommand> getScoresCommand() {
        return scoresCommand;
    }

    public void setScoresCommand(ArrayList<ScoresCommand> scoresCommand) {
        this.scoresCommand = scoresCommand;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "ScoresWrapper{" + "scoresCommand=" + scoresCommand + ", quiz=" + quiz + '}';
    }
   
}
