/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.dao;

import com.link.quizproject.command.ScoresCommand;
import com.link.quizproject.command.ScoresWrapper;
import com.link.quizproject.domain.Game;
import com.link.quizproject.rm.GameRowMapper;
import com.link.quizproject.rm.ScoresRowMapper;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zika
 */
@Repository
public class GameDAOImpl extends BaseDAO implements GameDAO {

    @Override
    public int save(Game g) throws SQLException {
        String sql = "INSERT INTO games(user_id, quiz_id, start_time, end_time, score)" + "VALUES (:user_id, :quiz_id, :start_time, :end_time :score)";
        Map m = new HashMap();
        m.put("user_id", g.getUser_id());
        m.put("quiz_id", g.getQuiz_id());
        m.put("start_time", g.getStart_time());
        m.put("end_time", g.getEnd_time());
        m.put("score", g.getScore());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer gameId = kh.getKey().intValue();
        g.setId(gameId);
        return gameId;
    }

    @Override
    public ArrayList<Game> findAll() {
        String sql = "SELECT id, user_id, quiz_id, start_time, end_time, score" + "FROM games";
        ArrayList<Game> games = (ArrayList<Game>) getJdbcTemplate().query(sql, new GameRowMapper());
        return games;
    }

    @Override
    public Game findById(Integer gameId) {
        String sql = "SELECT id, user_id, quiz_id, start_time, end_time, score" + " FROM games WHERE id=?";
        Game g = getJdbcTemplate().queryForObject(sql, new GameRowMapper(), gameId);
        return g;
    }

    @Override
    public void update(Game g) {
        String sql = "UPDATE games SET "
                + "user_id=:user_id, "
                + "quiz_id=:quiz_id, "
                + "end_time=:end_time, "
                + "score=:score "
                + "WHERE id=:id";

        Map m = new HashMap();
        m.put("user_id", g.getUser_id());
        m.put("quiz_id", g.getQuiz_id());
        m.put("end_time", new Timestamp(new Date().getTime()));
        m.put("score", g.getScore());
        m.put("id", g.getId());
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM games WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }

    //TO DO: Test this metod!
    @Override
    public Integer checkCorrectAnswer(int answerId) {
        String sql = "SELECT correct FROM answers WHERE id=" + answerId;
        Integer i = getJdbcTemplate().queryForObject(sql, Integer.class);
        return i;
    }

    @Override
    public Game createNewGame(int quizId, int userId) {
        String sql = "INSERT INTO games(user_id, quiz_id, start_time)" + "VALUES (:user_id, :quiz_id, :start_time)";
        Map m = new HashMap();
        m.put("user_id", userId);
        m.put("quiz_id", quizId);
        m.put("start_time", new Timestamp(new Date().getTime()));

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer gameId = kh.getKey().intValue();
        Game g = new Game(gameId, userId, quizId, null, null, 0);
        return g;
    }

    @Override
    public int createUserAnswer(int gameId, int questionId, int answerId) {
        String sql = "INSERT INTO user_answers(game_id, question_id, answer_id)" + "VALUES (:game_id, :question_id, :answer_id)";
        Map m = new HashMap();
        m.put("game_id", gameId);
        m.put("question_id", questionId);
        m.put("answer_id", answerId);

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userAnswerId = kh.getKey().intValue();
        return userAnswerId;
    }

    @Override
    public ScoresWrapper loadBestScores(int quizId) {
        ScoresWrapper sw = new ScoresWrapper();
        String sql
                = "SELECT g.*, u.username FROM games g JOIN users u ON g.user_id=u.id WHERE g.quiz_id=?"
                + " ORDER BY score DESC"
                + " LIMIT 10";
        sw.setScoresCommand((ArrayList<ScoresCommand>) getJdbcTemplate().query(sql, new ScoresRowMapper(), quizId));
        return sw;
    }

    @Override
    public ScoresWrapper userBestScores(int quizId,int userId) {
        ScoresWrapper sw = new ScoresWrapper();
        String sql
                = "SELECT g.*, u.username FROM games g JOIN users u ON g.user_id=u.id WHERE g.quiz_id=? AND g.user_id=?"
                + " ORDER BY score DESC"
                + " LIMIT 10";
        sw.setScoresCommand((ArrayList<ScoresCommand>) getJdbcTemplate().query(sql, new ScoresRowMapper(), quizId, userId));
        return sw;
    }

}

