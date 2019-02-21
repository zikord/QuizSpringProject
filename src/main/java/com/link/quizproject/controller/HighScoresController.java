
package com.link.quizproject.controller;

import com.link.quizproject.command.ScoresWrapper;
import com.link.quizproject.service.GameService;
import com.link.quizproject.service.QuizService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Zika
 */
@Controller
public class HighScoresController {
    
    @Autowired
    GameService gameService;
    
    @Autowired
    QuizService quizService;
    
    @RequestMapping(value = {"user/highscores"}, method= RequestMethod.GET)
    public ModelAndView highScores() {
        ArrayList<ScoresWrapper> sws = gameService.highScores();     
        return new ModelAndView("highScorePage", "sws", sws);
    }
      
}
