/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.link.quizproject.rm;

import com.link.quizproject.domain.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Zika
 */
public class GameRowMapper implements RowMapper<Game>{

    @Override
    public Game mapRow(ResultSet rs, int i) throws SQLException {
        Game g = new Game();
        g.setId(rs.getInt("id"));
        g.setUser_id(rs.getInt("user_id"));
        g.setQuiz_id(rs.getInt("quiz_id"));
        g.setStart_time(rs.getTimestamp("start_time"));
        g.setEnd_time(rs.getTimestamp("end_time"));
        g.setScore(rs.getInt("score"));
        return g;
    }
    
}
