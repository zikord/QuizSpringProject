/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.rm;

import com.link.quizproject.domain.UserAnswer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Zika
 */
public class UserAnswersRowMapper implements RowMapper<UserAnswer> {

    @Override
    public UserAnswer mapRow(ResultSet rs, int i) throws SQLException {
        UserAnswer ua = new UserAnswer();
        ua.setId(rs.getInt("id"));
        ua.setGame_id(rs.getInt("game_id"));
        ua.setQuestion_id(rs.getInt("question_id"));
        ua.setAnswer_id(rs.getInt("anwer_id"));
        return ua;
    }

}
