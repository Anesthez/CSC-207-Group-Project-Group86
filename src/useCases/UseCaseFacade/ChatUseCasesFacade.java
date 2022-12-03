package useCases.UseCaseFacade;

import entity.Chat;
import entity.factories.ChatFactory;
import model.request.ChatRequestModel;
import model.response.ChatResponseModel;
import useCases.AddChatUseCase;
import useCases.DeleteChatUseCase;
import useCases.GetChatUseCase;


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

public class ChatUseCasesFacade {

    private final Map<Integer, Chat> chats = new HashMap<>();
    private final AddChatUseCase acu;
    private final DeleteChatUseCase dcu;
    private final GetChatUseCase gcu;

    /**
     * <p>Constructor for the ChatUseCases. It takes in the hash map.</p>
     *
     * @param chats the hash map
     */

    public ChatUseCasesFacade(Map<Integer, ChatRequestModel> chats, AddChatUseCase acu,
                              DeleteChatUseCase dcu, GetChatUseCase gcu){
        ChatFactory chatFactory = new ChatFactory();
        for (ChatRequestModel chatRequestModel : chats.values()) {
             Chat chat = chatFactory.create(chatRequestModel);
             this.chats.put(chat.getId(), chat);
        }
        this.acu = acu;
        this.dcu = dcu;
        this.gcu = gcu;
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
        acu.addChat(user_id1, user_id2, content, chats);
    }

    /**
     * <p>remove a chat object from the hash map.</p>
     *
     * @param id the id of the chat
     */
    public void deleteChat(int id)
    {
        dcu.deleteChat(id, chats);
    }

    public Map<Integer, ChatResponseModel> getChats() {
        return gcu.getChats(chats);
    }
}
