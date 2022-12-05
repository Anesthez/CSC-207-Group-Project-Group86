package controller;

import databaseInterface.CsvInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>This class is responsible for adding a new friend to the friend list.</p>
 *
 * @author: yufeichen
 */

public class AddFriendController {
    public Boolean add(int userId, int friendId) throws IOException {
        Map<Integer, ArrayList<Integer>> friends =
                new CsvInterface().friendsReader("database/friends.csv");
        ArrayList<Integer> friendList = friends.get(userId);
        if (friendList == null){
            return false;
        }
        if (!friendList.contains(friendId) && !friends.containsKey(friendId)){
            friendList.add(friendId);
            new CsvInterface().friendsWriter("database/friends.csv", friends);
            return true;
        }else{
            return false;
        }

    }
}
