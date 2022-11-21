package Layer3.Controller;

import Layer4.Interface.csvInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AddFriendController {
    public Boolean add(int userId, int friendId) throws IOException {
        Map<Integer, ArrayList<Integer>> friends =
                new csvInterface().friendsReader("database/friends.csv");
        ArrayList<Integer> friendList = friends.get(userId);
        if (friendList == null){
            return false;
        }
        if (!friendList.contains(friendId)){
            friendList.add(friendId);
            return true;
        }else{
            return false;
        }

    }
}
