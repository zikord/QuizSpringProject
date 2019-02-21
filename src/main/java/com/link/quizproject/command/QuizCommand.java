/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.command;

import com.link.quizproject.domain.Answer;
import com.link.quizproject.domain.Question;
import com.link.quizproject.domain.Quiz;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public class QuizCommand {
                        
     private Quiz quiz;
    
     private Question question;
    
    private ArrayList<Answer> answers;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuizCommand{" + "quiz=" + quiz + ", question=" + question + ", answers=" + answers + '}';
    }
    
}
