/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.test;

import com.link.quizproject.command.ScoresWrapper;
import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.GameDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestLoadBestScore {
    public static void main(String[] args) {


        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        GameDAO gameDAO = ctx.getBean(GameDAO.class);
        ScoresWrapper games = gameDAO.loadBestScores(96);
        System.out.println(games);
    }
}
