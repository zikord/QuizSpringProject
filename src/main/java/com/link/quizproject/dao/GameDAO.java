package com.link.quizproject.dao;

import com.link.quizproject.command.ScoresWrapper;
import com.link.quizproject.domain.Game;

/**
 *
 * @author Zika
 */
public interface GameDAO extends EntityDAO<Game> {

    public Integer checkCorrectAnswer(int answerId);

    public Game createNewGame(int quizId, int userId);

    public int createUserAnswer(int gameId, int questionId, int answerId);

    public ScoresWrapper loadBestScores(int quizId);

    public ScoresWrapper userBestScores(int quizId, int userId);

}
