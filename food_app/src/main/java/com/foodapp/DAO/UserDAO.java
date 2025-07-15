package com.foodapp.DAO;
import java.util.List;
import com.foodapp.models.User;

public interface UserDAO {
	List <User> getAllUsers();
    User getUserById(int userId);
    void addUser(User u);
    void updateUser(User u);
    void deleteUser(int userid);
    
}
