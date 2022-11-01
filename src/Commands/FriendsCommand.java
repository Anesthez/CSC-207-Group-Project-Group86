package Commands;

import Entity.User;
import Interface.csvInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/*
Author: TianYu Li
 */
public class FriendsCommand{
    String[] inputLines;
    int userid;
    public FriendsCommand(String[] userLines, int userid){
        this.inputLines = userLines;
        this.userid = userid;
    }

    public void exact() throws IOException {
        csvInterface csvInteract = new csvInterface();
        Map<Integer, User> users = csvInteract.usersReader("database/user.csv");
        Map<Integer, ArrayList<Integer>> friends =
                csvInteract.friendsReader("database/friends.csv");
        Map<Integer, ArrayList<Integer>> blocks =
                csvInteract.blocksReader("database/blocks.csv");
        switch (inputLines[1]) {
            case "add": {
                int friendid = Integer.parseInt(inputLines[2]);
                if (blocks.get(userid).contains(friendid) && !friends.get(userid).contains(friendid)){
                    System.out.println("please unblock this user first");
                } else if (users.containsKey(friendid)) {
                    friends.get(userid).add(friendid);
                    csvInteract.friendsWriter("database/friends.csv", friends);
                } else {
                    System.out.println("user does not exist");
                }
                break;
            }
            case "remove": {
                int unfriendid = Integer.parseInt(inputLines[2]);
                if (users.containsKey(unfriendid)) {
                    friends.get(userid).remove(unfriendid);
                    csvInteract.friendsWriter("database/friends.csv", friends);
                } else {
                    System.out.println("user does not exist");
                }
                break;
            }
            case "adds": {
                boolean existsBlocked = false;
                String[] rawFriendids = inputLines[2].split(" ");
                for (String rawFriendid : rawFriendids) {
                    int friendid = Integer.parseInt(rawFriendid);
                    if (blocks.get(userid).contains(friendid)){
                        existsBlocked = true;
                    } else if (users.containsKey(friendid) && !friends.get(userid).contains(friendid)) {
                        friends.get(userid).add(friendid);
                    } else {
                        System.out.println("user: " + friendid + " does not exist");
                    }
                }
                csvInteract.friendsWriter("database/friends.csv", friends);
                if (existsBlocked){
                    System.out.println("skipped existed blocked user");
                }
                break;
            }
            case "removes": {
                String[] rawFriendids = inputLines[2].split(" ");
                for (String rawFriendid : rawFriendids) {
                    int unfriendid = Integer.parseInt(rawFriendid);
                    if (users.containsKey(unfriendid)) {
                        friends.get(userid).remove(unfriendid);
                    } else {
                        System.out.println("user: " + unfriendid + " does not exist");
                    }
                }
                csvInteract.friendsWriter("database/friends.csv", friends);
                break;
            }
            case "block":
                int blockedid = Integer.parseInt(inputLines[2]);
                if (users.containsKey(blockedid) && !blocks.get(userid).contains(blockedid)) {
                    blocks.get(userid).add(blockedid);
                    csvInteract.blocksWriter("database/blocks.csv", blocks);
                } else {
                    System.out.println("user does not exist");
                }
                break;
            case "unblock":
                int unblockedid = Integer.parseInt(inputLines[2]);
                if (users.containsKey(unblockedid)) {
                    blocks.get(userid).remove(unblockedid);
                    csvInteract.blocksWriter("database/blocks.csv", blocks);
                } else {
                    System.out.println("user does not exist");
                }
                break;
            default:
                System.out.println("unknown command");
                break;
        }
    }
}
