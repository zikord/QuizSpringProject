
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
public class TestUserDAOSave {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        //TODO the user detail will be taken from User-Reg-Form
        User u = new User();
        u.setName("sa");
        u.setUsername("da");
        u.setPassword("11");
        u.setRole(1);
        userDAO.save(u);
        System.out.println("-------DATA SAVED-------");
    }
    
}
