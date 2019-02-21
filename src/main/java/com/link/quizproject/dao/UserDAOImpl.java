
package com.link.quizproject.dao;

import com.link.quizproject.domain.User;
import com.link.quizproject.rm.UserRowMapper;
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
public class UserDAOImpl extends BaseDAO implements UserDAO{

    @Override
    public void save(User u) {
        String sql = "INSERT INTO users(name, username, password, role)" + "VALUES (:name, :username,:password, :role)";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("username", u.getUsername());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        
        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setId(userId);

    }

    @Override
    public void delete(User u) {
        this.delete(u.getId());
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE users SET "
                +"name=:name, "
                +"username=:username,"
                +"role=:role "
                +"WHERE id=:id";
        
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("username", u.getUsername());
        m.put("role", u.getRole());
        m.put("id", u.getId());
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer userId) {
        String sql = "DELETE FROM users WHERE id=?";
        getJdbcTemplate().update(sql, userId);
    }

    @Override
    public User findById(Integer userId) {
        String sql = "SELECT id, name, username, role" + " FROM users WHERE id=?";
        User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
        return u;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, name, username, role" + " FROM users";
        List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public List<User> findByProperty(String propName, Object propValue) {
        String sql = "SELECT id, name, username, role" + " FROM users WHERE "+propName+"=?";
        return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT id, name, username, role" + " FROM users WHERE username=?";
        User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), username);
        return u;
    }

}
