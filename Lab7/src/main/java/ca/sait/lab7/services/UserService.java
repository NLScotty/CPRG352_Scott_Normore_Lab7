package ca.sait.lab7.services;

import ca.sait.lab7.dataaccess.UserDB;
import java.util.List;
import ca.sait.lab7.models.generated.User;
import ca.sait.lab7.models.generated.Role;

public class UserService {
    private UserDB userDB = new UserDB();
    
    public User get(String email) throws Exception {
        User user = this.userDB.get(email);
        return user;
    }
    
    public List<User> getActive() throws Exception{
        List<User> users = this.userDB.getActive();
        return users;
    }
    
    public List<User> getAll() throws Exception {
        List<User> users = this.userDB.getAll();
        return users;
    }
    
    public boolean insert(String email, boolean active,String firstName,String lastName,String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        return this.userDB.insert(user);
    }
    
    public boolean update(String email, boolean active,String firstName,String lastName,String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        return this.userDB.update(user);
    }
    
    public boolean delete(String email) throws Exception {
        User user = get(email);
        return userDB.delete(user);
    }
}
