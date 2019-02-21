package com.link.quizproject.test;

import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.QuestionDAO;
import com.link.quizproject.domain.Question;
import com.link.quizproject.service.QuestionServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestLoadAnswers {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        QuestionDAO questionDAO = ctx.getBean(QuestionDAO.class);
        QuestionServiceImpl questionServiceImpl = ctx.getBean(QuestionServiceImpl.class);
        Question q;
        q = questionDAO.findById(1);
        //questionServiceImpl.loadPossibleAnswers(q);
        System.out.println(q);

    }

}
