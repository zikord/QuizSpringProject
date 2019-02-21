/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.test;

import com.link.quizproject.command.ScoresCommand;
import com.link.quizproject.command.ScoresWrapper;
import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.GameDAO;
import com.link.quizproject.domain.Quiz;
import com.link.quizproject.service.GameServiceImpl;
import com.link.quizproject.service.QuizServiceImpl;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestHighScoresService {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        GameDAO gameDAO = ctx.getBean(GameDAO.class);
        GameServiceImpl gameServiceImpl = ctx.getBean(GameServiceImpl.class);
        QuizServiceImpl quizServiceImpl = ctx.getBean(QuizServiceImpl.class);

        // ArrayList<ScoresWrapper> sw = gameServiceImpl.highScores();
        ScoresWrapper sw = new ScoresWrapper();
        ArrayList<ScoresWrapper> sws = new ArrayList<>();
        ArrayList<Quiz> quizes = (ArrayList<Quiz>) quizServiceImpl.getQuizList();
        for (Quiz quiz : quizes) {
            sw = (gameDAO.userBestScores(quiz.getId(), 43));
            sw.setQuiz(quiz);
            sws.add(sw);
        }
        System.out.println(sws);
    }
}
