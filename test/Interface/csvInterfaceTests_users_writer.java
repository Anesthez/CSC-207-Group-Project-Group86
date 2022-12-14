package Interface;

import entity.User;
import databaseInterface.CsvInterface;
import model.response.UserResponseModel;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test usersWriter method in csvInterface class
 *
 * @Author: Yijun(Kevin) Zhao
 */

public class csvInterfaceTests_users_writer {
    CsvInterface csv = new CsvInterface();
    String usersPath = "test/Interface/test_users.csv";

    @Test(timeout = 500)
    public void test_usersWriter_1user() throws IOException {
        Map<Integer, UserResponseModel> users = new HashMap<>();
        User user = new User(1, "normal", "User1", "123456", "2020-11-11 11:11:11");
        users.put(1, user.responseModel());
        csv.usersWriter(users, usersPath);

        File csvFile = new File(usersPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user-type,password,name,time", reader.readLine());
        assertEquals("1,normal,123456,User1,2020-11-11 11:11:11", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_usersWriter_2users() throws IOException {
        Map<Integer, UserResponseModel> users = new HashMap<>();
        User user = new User(1, "normal", "User1", "123456", "2020-11-11 11:11:11");
        users.put(1, user.responseModel());
        User user2 = new User(2, "admin", "User2", "123456", "2020-11-11 11:11:11");
        users.put(2, user2.responseModel());
        csv.usersWriter(users, usersPath);

        File csvFile = new File(usersPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user-type,password,name,time", reader.readLine());
        assertEquals("1,normal,123456,User1,2020-11-11 11:11:11", reader.readLine());
        assertEquals("2,admin,123456,User2,2020-11-11 11:11:11", reader.readLine());
    }

    @Test(timeout = 500)
    public void test_usersWriter_3users() throws IOException {
        Map<Integer, UserResponseModel> users = new HashMap<>();
        User user = new User(1, "normal", "User1", "123456", "2020-11-11 11:11:11");
        users.put(1, user.responseModel());
        User user2 = new User(2, "admin", "User2", "123456", "2020-11-11 11:11:11");
        users.put(2, user2.responseModel());
        User user3 = new User(3, "normal", "User3", "123456", "2020-11-11 11:11:11");
        users.put(3, user3.responseModel());
        csv.usersWriter(users, usersPath);

        File csvFile = new File(usersPath);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        assertEquals("id,user-type,password,name,time", reader.readLine());
        assertEquals("1,normal,123456,User1,2020-11-11 11:11:11", reader.readLine());
        assertEquals("2,admin,123456,User2,2020-11-11 11:11:11", reader.readLine());
        assertEquals("3,normal,123456,User3,2020-11-11 11:11:11", reader.readLine());
    }
}