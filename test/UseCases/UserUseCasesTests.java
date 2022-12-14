package UseCases;

import junit.framework.TestCase;
import model.request.UserRequestModel;
import model.response.UserResponseModel;
import useCases.UseCaseFacade.UserUsesCasesFacade;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserUseCasesTests extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddUser() {
        Map<Integer, UserRequestModel> HashMap;
        UserUsesCasesFacade manager = new UserUsesCasesFacade(new HashMap<>());
        manager.addUser("test", "test");
        UserResponseModel user = manager.getUsers().get(1);
        assertTrue(user.equals(new UserResponseModel(1, "normal", "test", "test",
                LocalDate.now().toString())));

    }

    public void testVerifyUser() {
        Map<Integer, UserRequestModel> HashMap;
        UserUsesCasesFacade manager = new UserUsesCasesFacade(new HashMap<>());
        manager.addUser("test", "test");
        assertTrue((int) manager.verifyUser("test", "test").get().get(0) != -1);
    }

    public void testGetUsers(){
        Map<Integer, UserRequestModel> HashMap;
        UserUsesCasesFacade manager = new UserUsesCasesFacade(new HashMap<>());
        manager.addUser("test", "test");
        Map<Integer, UserResponseModel> users = manager.getUsers();
        assertTrue(users.equals(new HashMap<Integer, UserResponseModel>() {{
            put(1, new UserResponseModel(1, "normal", "test", "test",
                    LocalDate.now().toString()));
        }}));
    }
}