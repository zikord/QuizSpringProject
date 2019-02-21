/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public class Question extends EntityImpl implements Serializable{

    private int quiz_id;
    private String title;
    private String text;
    private ArrayList<Answer> answers;
    private ArrayList<UserAnswer> userAnswer;

    public Question() {
    }
    
    public Question(int id, int quiz_id, String title, String text){
        super(id);
        this.quiz_id = quiz_id;
        this.title = title;
        this.text = text;
        this.answers = new ArrayList<>();       
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public ArrayList<UserAnswer> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(ArrayList<UserAnswer> userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void addAnswer(Answer a){
        answers.add(a);
    }
    
    public void removeAnswer(Answer a){
        answers.remove(a);
    }

    public void addUserAnswer(UserAnswer ua){
        this.userAnswer.add(ua);
    }
    
    public void removeUserAnswer(UserAnswer ua){
        this.userAnswer.remove(ua);
    }

    @Override
    public String toString() {
        return "Question{" + "quiz_id=" + quiz_id + ", title=" + title + ", text=" + text + ", answers=" + answers + ", userAnswer=" + userAnswer + '}';
    }
    
    
}
