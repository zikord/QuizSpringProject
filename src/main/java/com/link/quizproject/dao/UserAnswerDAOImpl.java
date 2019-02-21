package com.link.quizproject.dao;

import com.link.quizproject.domain.UserAnswer;
import com.link.quizproject.rm.UserAnswersRowMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


/**
 *
 * @author Zika
 */
public class UserAnswerDAOImpl extends BaseDAO implements EntityDAO<UserAnswer>{

    @Override
    public int save(UserAnswer ua) throws SQLException {
        String sql = "INSERT INTO user_answers(game_id, question_id, answer_id)" + "VALUES (:game_id, :question_id, :answer_id)";
        Map m = new HashMap();
        m.put("game_id", ua.getGame_id());
        m.put("question_id", ua.getQuestion_id());
        m.put("answer_id", ua.getAnswer_id());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userAnswerId = kh.getKey().intValue();
        ua.setId(userAnswerId);
        return userAnswerId;
    }

    @Override
    public ArrayList<UserAnswer> findAll() {
        String sql = "SELECT id, quiz_id, title, text" + "FROM user_answers";
        ArrayList<UserAnswer> ua = (ArrayList<UserAnswer>) getJdbcTemplate().query(sql, new UserAnswersRowMapper());
        return ua;
    }

    @Override
    public UserAnswer findById(Integer id) {
        String sql = "SELECT id, game_id, question_id, answer_id" + "FROM user_answers WHERE id=?";
        UserAnswer ua = getJdbcTemplate().queryForObject(sql, new UserAnswersRowMapper(), id);
        return ua;
    }

    @Override
    public void update(UserAnswer ua) {
        String sql = "UPDATE user_answers SET "
                + "game_id=:game_id, "
                + "question_id=:question_id, "
                + "answer_id=:answer_id "
                + "WHERE id=:id";

        Map m = new HashMap();
        m.put("game_id", ua.getGame_id());
        m.put("question_id", ua.getQuestion_id());
        m.put("answer_id", ua.getAnswer_id());
        m.put("id", ua.getId());
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM user_answers WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }

    
}
