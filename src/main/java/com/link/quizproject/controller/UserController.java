/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.controller;

import com.link.quizproject.command.LoginCommand;
import com.link.quizproject.command.ScoresWrapper;
import com.link.quizproject.command.UserCommand;
import com.link.quizproject.domain.Quiz;
import com.link.quizproject.domain.User;
import com.link.quizproject.service.GameService;
import com.link.quizproject.service.QuizService;
import com.link.quizproject.service.UserService;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Zika
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private GameService gameService;

    @RequestMapping(value = {"/", "/index1"}, method = RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        m.addAttribute("command1", new UserCommand());
        return "index1"; // JSP - /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = {"/user/home"}, method = RequestMethod.GET)
    public String userHomePage(Model m) {
        Collection<Quiz> quizes = quizService.getQuizList();
        m.addAttribute("quizList", quizes);
        return "userHomePage";
    }

    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminDashboard() {
        return "dashboard_admin";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index1";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser = userService.login(cmd.getUsername(), cmd.getPassword());
            if (loggedInUser == null) {
                m.addAttribute("errorMsg", "Login failed, please try again");
                return "index1";
            } else {
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/home";
                } else {
                    m.addAttribute("err", "INVALID USER ROLE");
                    return "index1";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "index1";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("command1") User user) {
        try {
            user.setRole(UserService.ROLE_USER);
            userService.registration(user);
            return new ModelAndView("index1", "successMsg", "Registration complete, please login in"); //JSP
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return new ModelAndView("index1", "errorMsg", "Registration failed, username already exist please try another username");
        }
    }

    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getId());
        session.setAttribute("role", u.getRole());
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public ModelAndView userInfo(WebRequest request, HttpSession session, Model m) {
        User user = (User) session.getAttribute("user");
        ArrayList<ScoresWrapper> sws = gameService.userHighScores(user.getId());
        m.addAttribute("sws", sws);
        return new ModelAndView("userInfoPage", "user", user);
    }
    
    
    @RequestMapping(value = "/user/about", method = RequestMethod.GET)
    public String userAbout(){
        return "aboutInfo";
    }
    
}
