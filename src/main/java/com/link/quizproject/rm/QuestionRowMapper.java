/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.rm;

import com.link.quizproject.domain.Question;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Zika
 */
public class QuestionRowMapper implements RowMapper<Question>{

    @Override
    public Question mapRow(ResultSet rs, int i) throws SQLException {
        Question q = new Question();
        q.setId(rs.getInt("id"));
        q.setQuiz_id(rs.getInt("quiz_id"));
        q.setTitle(rs.getString("title"));
        q.setText(rs.getString("text"));
        return q;
    }
    
}
