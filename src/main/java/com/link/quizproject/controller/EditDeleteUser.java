package com.link.quizproject.controller;

import com.link.quizproject.dao.UserDAO;
import com.link.quizproject.domain.User;
import com.link.quizproject.service.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Grupa1
 */
@Controller
public class EditDeleteUser {

    @Autowired
    UserService userService;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "admin/userList")
    public String adminQUserList(Model m) {
        ArrayList<User> users = (ArrayList<User>) userService.getUserList();
        m.addAttribute("userList", users);
        return "userListAdmin"; // JSP view
    }

    @RequestMapping(value = "admin/userDel", method = RequestMethod.POST)    
    public @ResponseBody void deleteUser(@RequestParam Integer id) {
        try {
            System.out.println(id);
            userService.deleteUser(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "admin/editUser", method = RequestMethod.POST)
    @ResponseBody
    public void handleEditUser(@RequestBody User user) {
        try {
            userDAO.update(user);
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
        }
    }
}
