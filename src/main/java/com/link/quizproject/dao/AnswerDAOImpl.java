/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.dao;

import com.link.quizproject.domain.Answer;
import com.link.quizproject.rm.AnswerRowMapper;
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
public class AnswerDAOImpl extends BaseDAO implements AnswerDAO {

    @Override
    public int save(Answer a) throws SQLException {
        String sql = "INSERT INTO answers(question_id, text, correct)" + "VALUES (:question_id, :text, :correct)";
        Map m = new HashMap();
        m.put("question_id", a.getQuestion_id());
        m.put("text", a.getText());
        m.put("correct", a.getCorrect());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer answerId = kh.getKey().intValue();
        a.setId(answerId);
        return answerId;
    }

    @Override
    public ArrayList<Answer> findAll() {
        String sql = "SELECT id, question_id, text, correct" + "FROM answers";
        ArrayList<Answer> ans = (ArrayList<Answer>) getJdbcTemplate().query(sql, new AnswerRowMapper());
        return ans;
    }

    @Override
    public Answer findById(Integer answerId) {
        String sql = "SELECT id, question_id, text, correct" + " FROM answers WHERE id=?";
        Answer a = getJdbcTemplate().queryForObject(sql, new AnswerRowMapper(), answerId);
        return a;
    }

    @Override
    public void update(Answer a) {
        String sql = "UPDATE answers SET "
                + "question_id=:question_id, "
                + "text=:text, "
                + "correct=:correct "
                + "WHERE id=:id";

        Map m = new HashMap();
        m.put("question_id", a.getQuestion_id());
        m.put("text", a.getText());
        m.put("correct", a.getCorrect());
        m.put("id", a.getId());
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM answers WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public ArrayList<Answer> getAnswersByQuestionId(Integer id) {
        String sql = "SELECT id, question_id, text, correct FROM answers WHERE question_id=?";
        ArrayList<Answer> ans = (ArrayList<Answer>) getJdbcTemplate().query(sql, new AnswerRowMapper(), id);
        return ans;
    }

}
