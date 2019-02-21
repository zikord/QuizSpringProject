package com.link.quizproject.test;

import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.AnswerDAO;
import com.link.quizproject.domain.Answer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestAnswerDAOFindById {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        AnswerDAO answerDAO = ctx.getBean(AnswerDAO.class);
        Answer ans = answerDAO.findById(151);
        System.out.println(ans);
        
        

    }

}
