
package com.link.quizproject.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zika
 */
public class User extends EntityImpl implements Serializable{

    private String name;
    private String username;
    private String password;
    private Integer role;
    private ArrayList<Game> games;

    public User() {
    }

    public User(String name, String username, String password, Integer role, int id) {
        super(id);
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.games = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
    
    public void addGames(Game g){
        this.games.add(g);
    }
    
    public void removeGames(Game g){
        this.games.remove(g);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", role=" + role + '}';
    }
    
    
}
