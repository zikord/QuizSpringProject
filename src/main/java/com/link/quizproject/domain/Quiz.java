/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public class Quiz extends EntityImpl implements Serializable{
    
    private String name;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String about;
    private ArrayList<Question> questions;
    private ArrayList<Game> games;

    public Quiz() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
    
    public void addQuestion(Question q){
        this.questions.add(q);
    }
    
    public void removeQuestion(Question q){
        this.questions.remove(q);
    }
    
    public void addGames(Game g){
        this.games.add(g);
    }
    
    public void removeGames(Game g){
        this.games.remove(g);
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Quiz{" + "name=" + name + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", about=" + about + ", questions=" + questions + ", games=" + games + '}';
    }
  
    
}
