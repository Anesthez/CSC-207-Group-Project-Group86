package UseCases;

import junit.framework.TestCase;
import model.response.ChatResponseModel;
import org.junit.Test;
import useCases.AddChatUseCase;
import useCases.UseCaseFacade.ChatUseCasesFacade;
import useCases.DeleteChatUseCase;
import useCases.GetChatUseCase;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>ChatUseCasesTest is a test class for ChatUseCases.</p>
 * @Author: Jiahao Gu
 * @Modifiedby: LemengDai
 */
public class ChatUseCasesTests extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    @Test(timeout = 500)
    public void testAddChat() {
        ChatUseCasesFacade manager = new ChatUseCasesFacade(new HashMap<>());
        manager.addChat(1, 2, "Hello" );
        ChatResponseModel chat = manager.getChats().get(1);
        String actual = "Hello";
        String expected = (String) chat.get().get(3);
        assertEquals("There is error in ChatManager.addChat!", actual, expected);

    }
    @Test(timeout = 500)
    public void testDeleteChat() {
        ChatUseCasesFacade manager = new ChatUseCasesFacade(new HashMap<>());
        manager.addChat(1, 2, "Hello" );
        manager.addChat(1, 2, "I'm Alice" );
        manager.deleteChat(1);
        ChatResponseModel actual = manager.getChats().get(1);
        assertNull("There is error in ChatManager.deleteChat!", actual);
    }
    @Test(timeout = 500)
    public void testGetChats() {
        ChatUseCasesFacade manager = new ChatUseCasesFacade(new HashMap<>());
        manager.addChat(1, 2, "Hello");
        manager.addChat(1, 2, "I'm Alice");
        Map<Integer, ChatResponseModel> chatResponseModelMap = manager.getChats();
        String actual = (String) chatResponseModelMap.get(2).get().get(3);
        String expected = "I'm Alice";
        assertEquals("There is error in ChatManager.getChats!", actual, expected);
    }
}
