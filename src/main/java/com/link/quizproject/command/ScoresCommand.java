package com.link.quizproject.command;

import java.sql.Timestamp;

/**
 *
 * @author Zika
 */
public class ScoresCommand {

    private int id;

    private int quizId;

    private Timestamp endTime;

    private String username;

    private int score;

    public ScoresCommand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoresCommand{" + "id=" + id + ", quizId=" + quizId + ", endTime=" + endTime + ", username=" + username + ", score=" + score + '}';
    }
    
}
