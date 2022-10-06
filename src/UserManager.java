public class UserManager {
    public void addUser(int userId, String userName, String userPassword) {
        User u = new User(userId, userName, userPassword);
        //TODO add user into csv file
    }

    public void deleteUser(int userId) {
        //TODO csv operation
    }

    public void changePassword(int userId) {
        //TODO csv operations
    }

    public void changeUsername(int userId) {
        //TODO csv operations
    }

    /**
     * TODO
     * get userId with userName
     * see whether the password is match or not
     * return result
     */
    public Boolean verifyUser(String userName, String userPassword) {
        return false;
    }
}
