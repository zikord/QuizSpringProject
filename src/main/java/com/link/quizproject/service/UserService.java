
package com.link.quizproject.service;

import com.link.quizproject.domain.User;
import java.util.List;

/**
 *
 * @author Zika
 */
public interface UserService {
    
    public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_USER = 0;
    
    public void registration(User u);
    
    public User login(String loginName, String password);
    
    public List<User> getUserList();
    
    public void deleteUser(Integer id);
    
     public User getUserById(Integer id);
     
      public void updateUser(User u);

}
