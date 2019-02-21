/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.rm;

import com.link.quizproject.domain.Answer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Zika
 */
public class AnswerRowMapper implements RowMapper<Answer>{

    @Override
    public Answer mapRow(ResultSet rs, int i) throws SQLException {
        Answer a = new Answer();
        a.setId(rs.getInt("id"));
        a.setQuestion_id(rs.getInt("question_id"));
        a.setText(rs.getString("text"));
        a.setCorrect(rs.getInt("correct"));
        return a;
    }
    
}
