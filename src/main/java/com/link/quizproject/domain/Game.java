
package com.link.quizproject.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zika
 */
public class Game extends EntityImpl implements Serializable{

    private int user_id;
    private int quiz_id;
    private Timestamp start_time;
    private Timestamp end_time;
    private int score;
    private List<UserAnswer> userAnswer;

    public Game() {
    }

    public Game(int id, int user_id, int quiz_id, Timestamp start_time, Timestamp end_time, int score) {
        super(id);
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.score = score;
        this.userAnswer = new ArrayList<>();
    }

    public void addUserAnswer(UserAnswer ua) {
        this.userAnswer.add(ua);
    }

    public void removeUserAnswer(UserAnswer ua) {
        this.userAnswer.remove(ua);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<UserAnswer> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<UserAnswer> userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "Game{" + "user_id=" + user_id + ", quiz_id=" + quiz_id + ", start_time=" + start_time + ", end_time=" + end_time + ", score=" + score + ", userAnswer=" + userAnswer + '}';
    }

}
