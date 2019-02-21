/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.dao;

import com.link.quizproject.domain.Game;
import com.link.quizproject.domain.Question;
import com.link.quizproject.domain.Quiz;
import com.link.quizproject.rm.GameRowMapper;
import com.link.quizproject.rm.QuestionRowMapper;
import com.link.quizproject.rm.QuizRowMapper;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class QuizDAOImpl extends BaseDAO implements QuizDAO {

    @Override
    public int save(Quiz q) throws SQLException {
        String sql = "INSERT INTO quizes(name, about)" + "VALUES (:name, :about)";
        Map m = new HashMap();
        m.put("name", q.getName());
        m.put("about", q.getAbout());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer quizId = kh.getKey().intValue();
        q.setId(quizId);
        return quizId;
    }

    @Override
    public ArrayList<Quiz> findAll() {
        String sql = "SELECT * " + "FROM quizes";
        ArrayList<Quiz> quizes = (ArrayList<Quiz>) getJdbcTemplate().query(sql, new QuizRowMapper());
        return quizes;
    }

    @Override
    public Quiz findById(Integer id) {
        String sql = "SELECT * FROM quizes WHERE id=?";
        Quiz q = getJdbcTemplate().queryForObject(sql, new QuizRowMapper(), id);
        return q;
    }

    @Override
    public void update(Quiz q) {
        String sql = "UPDATE quizes SET "
                + "name=:name, "
                + "modified_date=:modified_date, "
                + "about=:about "
                + "WHERE id=:id";

        Map m = new HashMap();
        m.put("name", q.getName());
        m.put("modified_date", q.getModifiedDate());
        m.put("about", q.getAbout());
        m.put("id", q.getId());
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM quizes WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public ArrayList<Question> loadQuestions(Quiz q) {
        String sql = "SELECT id, quiz_id, title, text FROM questions WHERE quiz_id=?";
            ArrayList<Question> quest = (ArrayList<Question>) getJdbcTemplate().query(sql, new QuestionRowMapper(), q.getId());
            return quest;
    }

    @Override
    public ArrayList<Game> loadGames(Quiz q) {
        String sql = "SELECT id, user_id, quiz_id, start_time, end_time, score FROM games WHERE quiz_id=?";
            ArrayList<Game> game = (ArrayList<Game>) getJdbcTemplate().query(sql, new GameRowMapper(), q.getId());
            return game;
    }

}
