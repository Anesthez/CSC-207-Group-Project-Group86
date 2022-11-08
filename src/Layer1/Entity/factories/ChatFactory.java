package Layer1.Entity.factories;

import Layer1.Entity.Chat;

public class ChatFactory {
    public Chat create(int id, int user1_id, int user2_id, String content, String timestamp){
        return new Chat(id, user1_id, user2_id, content, timestamp);
    }
}
