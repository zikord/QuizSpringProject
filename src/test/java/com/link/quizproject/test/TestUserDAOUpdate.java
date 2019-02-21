
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
public class TestUserDAOUpdate {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        //TODO the user detail will be taken from Update User Profile Page
        User u = new User();
        u.setId(2);
        u.setName("Ana Anic");
        u.setUsername("Anic");
        u.setRole(1);
        userDAO.update(u);
        System.out.println("-------DATA UPDATED-------");
    }
    
}
