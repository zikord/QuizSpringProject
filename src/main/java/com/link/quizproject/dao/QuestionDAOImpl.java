package com.link.quizproject.dao;

import com.link.quizproject.domain.Answer;
import com.link.quizproject.domain.Question;
import com.link.quizproject.rm.AnswerRowMapper;
import com.link.quizproject.rm.QuestionRowMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class QuestionDAOImpl extends BaseDAO implements QuestionDAO {

    @Override
    public int save(Question q) throws SQLException {
        String sql = "INSERT INTO questions(quiz_id, title, text)" + "VALUES (:quiz_id,:title, :text)";
        Map m = new HashMap();
        m.put("quiz_id", q.getQuiz_id());
        m.put("title", q.getTitle());
        m.put("text", q.getText());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer questionId = kh.getKey().intValue();
        q.setId(questionId);
        return questionId;
    }

    @Override
    public ArrayList<Question> findAll() {
        String sql = "SELECT id, quiz_id, title, text" + " FROM questions";
        ArrayList<Question> quest = (ArrayList<Question>) getJdbcTemplate().query(sql, new QuestionRowMapper());
        return quest;
    }

    @Override
    public Question findById(Integer id) {
        String sql = "SELECT id, quiz_id, title, text" + " FROM questions WHERE id=?";
        Question q = getJdbcTemplate().queryForObject(sql, new QuestionRowMapper(), id);
        return q;
    }

    @Override
    public void update(Question q) {
        String sql = "UPDATE questions SET "
                + "quiz_id=:quiz_id, "
                + "title=:title, "
                + "text=:text "
                + "WHERE id=:id";

        Map m = new HashMap();
        m.put("quiz_id", q.getQuiz_id());
        m.put("title", q.getTitle());
        m.put("text", q.getText());
        m.put("id", q.getId());
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM questions WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }


    @Override
    public ArrayList<Answer> loadPossibleAnswer(Question q) {
        String sql = "SELECT id, question_id, text, correct from answers WHERE question_id=?";
            ArrayList<Answer> ansL = (ArrayList<Answer>) getJdbcTemplate().query(sql, new AnswerRowMapper(), q.getId());
            return ansL;
        }                

    @Override
    public ArrayList<Question> findQuestionByQuizId(Integer id) {
        String sql = "SELECT * FROM questions WHERE quiz_id=?";
        ArrayList<Question> quest = (ArrayList<Question>) getJdbcTemplate().query(sql, new QuestionRowMapper(), id);
        return quest;
    }

}
