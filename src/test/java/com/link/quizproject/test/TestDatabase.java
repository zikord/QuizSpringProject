package com.link.quizproject.test;

import com.link.quizproject.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Zika
 */
public class TestDatabase {


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String query = "INSERT INTO users(`name`, `username`, `password`, `role`) VALUES (?,?,?,?)";
        Object[] paaram = new Object[]{"Ana32", "Ana40", "anic", "0"};
        jt.update(query, paaram);
        System.out.println("------SQL Executed--------");
    }
    
}
