/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.service;

import com.link.quizproject.dao.BaseDAO;
import com.link.quizproject.dao.UserDAO;
import com.link.quizproject.domain.User;
import com.link.quizproject.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zika
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public void registration(User u){
        userDAO.save(u);             
    }
    
    private boolean usernameExist(String username) {
        User user = userDAO.findByUsername(username);
        return user != null;
    }
    
    @Override
    public User login(String username, String password) {
        String sql = "SELECT id, name, username, role FROM users WHERE username=:un and password=:pw";
        Map m = new HashMap();
        m.put("un", username);
        m.put("pw", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            return u;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> users = userDAO.findAll();
        return users;
    }

    @Override
    public void deleteUser(Integer id) {
        this.userDAO.delete(id);
    }

    @Override
    public User getUserById(Integer id) {
        User user = userDAO.findById(id);
        return user;
    }

    @Override
    public void updateUser(User u) {
        userDAO.update(u);
    }

}
