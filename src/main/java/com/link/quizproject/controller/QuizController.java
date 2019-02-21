package com.link.quizproject.controller;

import com.link.quizproject.command.ProcessQuiz;
import com.link.quizproject.command.QuizFormCommand;
import com.link.quizproject.domain.Game;
import com.link.quizproject.domain.User;
import com.link.quizproject.service.AnswerService;
import com.link.quizproject.service.GameService;
import com.link.quizproject.service.QuestionService;
import com.link.quizproject.service.QuizService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Zika
 */
@Controller
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    GameService gameService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "user/quizStart", method = RequestMethod.GET)
    public ModelAndView quiz(HttpSession session, @RequestParam("id") Integer id) {
        User user = (User) session.getAttribute("user");
        QuizFormCommand cmd = new QuizFormCommand();
        Game game = gameService.startNewGame(user.getId(), id);
        cmd.setQuiz(quizService.getQuizById(id));
        cmd.setQuestions(cmd.getQuiz().getQuestions());
        ModelAndView modelAndView = new ModelAndView("quiz");
        modelAndView.addObject("cmd", cmd);
        session.setAttribute("game", game);
        return modelAndView;
    }


    @RequestMapping(value = "user/processQuiz", method = RequestMethod.POST)
    public ModelAndView processQuiz(@ModelAttribute("cmd") ProcessQuiz cmd, HttpSession session) throws Exception {
        Game game = (Game) session.getAttribute("game");  
        game.setScore(gameService.checkCorrectAnswer(cmd.getAnswers()));
        gameService.updateGame(game);
        String score = gameService.processScore(cmd.getQuestions(), cmd.getAnswers());
        session.removeAttribute("game");
        return new ModelAndView("processQuiz", "score", score);
    }
}
