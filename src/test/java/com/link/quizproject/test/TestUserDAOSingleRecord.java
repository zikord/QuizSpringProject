package com.link.quizproject.test;

import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.UserDAO;
import com.link.quizproject.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestUserDAOSingleRecord {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = userDAO.findById(38);
        System.out.println("-------User Details-------");
        System.out.println(u);

    }

}
