package Layer1.Entity.factories;

import Layer1.Entity.User;

public class UserFactory {
    public User create(int id,String userType, String userName, String userPassword, String timestamp){
        return new User(id,userType , userName, userPassword, timestamp);
    }
}
