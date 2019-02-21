package com.link.quizproject.test;

import com.link.quizproject.config.SpringRootConfig;
import com.link.quizproject.dao.UserDAO;
import com.link.quizproject.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Zika
 */
public class TestUserDAOFindAll {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        List<User> users = userDAO.findAll();
        for (User u : users) {
            System.out.println(u.getId());
            System.out.println(u.getName());
            System.out.println(u.getRole());
            System.out.println(u.getUsername());
        }

    }

}
