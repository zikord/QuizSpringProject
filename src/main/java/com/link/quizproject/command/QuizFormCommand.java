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
 * @author Grupa1
 */
public class QuizFormCommand {
    
    private Quiz quiz;
    
    private ArrayList<Question> questions;
    
    private ArrayList<Answer> answers;


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "QuizFormCommand{" + "quiz=" + quiz + ", questions=" + questions + ", answers=" + answers + '}';
    }
 
}
