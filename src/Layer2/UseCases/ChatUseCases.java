package Layer2.UseCases;

import Layer1.Entity.Chat;
import Layer1.Entity.factories.ChatFactory;
import Model.Request.ChatRequestModel;
import Model.Response.ChatResponseModel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>The ChatUseCases contains a hash map mapping the id of the chat with the corresponding {@link Chat Chat} object.
 * to initialize it, we need the hash map.</p>
 *
 * <p>There are four use cases. addChat create a new chat object and add it and the id into the hash map.
 * deleteChat remove a chat object from the hash map.
 * getChatById returns a chat that has the inputted id.
 * getIdByUserAndTime returns the id of the chat with inputted sender's id, receiver's id and time sent</p>
 *
 * @Author: Jiahao Gu
 * @Modifiedby: Yufei Chen
 */

public class ChatUseCases {

    private final Map<Integer, Chat> chats = new HashMap<>();

    /**
     * <p>Constructor for the ChatUseCases. It takes in the hash map.</p>
     *
     * @param chats the hash map
     */
    public ChatUseCases(Map<Integer, ChatRequestModel> chats) throws IOException {
        ChatFactory chatFactory = new ChatFactory();
        for (ChatRequestModel chatRequestModel : chats.values()) {
             Chat chat = chatFactory.create(chatRequestModel);
             this.chats.put(chat.getId(), chat);

        }
    }

    /**
     * <p>add a new chat object and add it and the id into the hash map.</p>
     *
     * @param user_id1 the id of the user that sent the chat
     * @param user_id2 the id of the user that received the chat
     * @param content the content of the chat
     */
    public void addChat(int user_id1, int user_id2, String content)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
        Chat chat = new Chat(chats.keySet().size() + 1, user_id1, user_id2,
                content, LocalDateTime.now().format(formatter));
        chats.put(chat.getId(), chat);
    }

    /**
     * <p>remove a chat object from the hash map.</p>
     *
     * @param id the id of the chat
     */
    public void deleteChat(int id)
    {
        chats.remove(id);

    }
    /**
     * <p>returns a chat that has the inputted id.</p>
     *
     * @param id the id of the chat
     * @return the chat with the inputted id
     */
    public Chat getChatById(int id)
    {
        return chats.get(id);
    }

    /**
     * <p>returns the id of the chat with inputted sender's id, receiver's id and time sent</p>
     *
     * @param sender the id of the user that sent the chat
     * @param receiver the id of the user that received the chat
     * @param timestamp the time that the chat is sent
     * @return the id of the chat
     */
    public int getIdByUserAndTime(int sender, int receiver, String timestamp){
        for (int id: chats.keySet()){
            if (chats.get(id).getSender_id() == sender && chats.get(id).getReceiver_id() == receiver &&
                    chats.get(id).getTime().equals(timestamp)){
                return id;
            }
        }
        return 0;
    }
    public Map<Integer, ChatResponseModel> getChats() {
        Map<Integer, ChatResponseModel> chatResponseModelMap = new HashMap<>();
        for (Chat chat : chats.values()) {
            chatResponseModelMap.put(chat.getId(), chat.responseModel());
        }
        return chatResponseModelMap;
    }

}
