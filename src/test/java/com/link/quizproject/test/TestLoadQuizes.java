/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.test;

import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.QuizDAO;
import com.link.quizproject.domain.Quiz;
import com.link.quizproject.service.QuizServiceImpl;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestLoadQuizes {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        QuizDAO quizDAO = ctx.getBean(QuizDAO.class);
        QuizServiceImpl quizServiceImpl = ctx.getBean(QuizServiceImpl.class);
        Quiz q;
        q= quizDAO.findById(25);
        quizServiceImpl.loadQuestions(q);
        System.out.println(q);
    }
}
