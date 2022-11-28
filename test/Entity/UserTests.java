package Entity;

import entity.User;
import org.junit.*;
import static org.junit.Assert.*;

/*
 * Author: Eric Li
 */
public class UserTests {

    static User actual;
    @BeforeClass
    public static void setUp() { actual = new User(12345, "VIP", "abc", "123qweASD",
            "2020-01-01 00:00:00");
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testGetId(){
        assertEquals(12345, actual.getId());
    }

    @Test(timeout = 500)
    public void testGetUsername(){
        assertEquals("abc", actual.getUserName());
    }

    @Test(timeout = 500)
    public void testGetPassword(){
        assertEquals("123qweASD", actual.getUserPassword());
    }

    @Test(timeout = 500)
    public void testGetUserType(){
        assertEquals("VIP", actual.getUserType());
    }
    @Test(timeout = 500)
    public void testSetUserType(){
        actual.setUserType("level1");
        assertEquals("level1", actual.getUserType());
    }

    @Test(timeout = 500)
    public void testGetTimestamp(){
        assertEquals("2020-01-01 00:00:00", actual.getTime());
    }

    @Test(timeout = 500)
    public void testSetUsername(){
        actual.setUserName("eric");
        assertEquals("eric", actual.getUserName());
    }

    @Test(timeout = 500)
    public void testSetPassword(){
        actual.setUserPassword("098poiLKJ");
        assertEquals("098poiLKJ", actual.getUserPassword());
    }

    @Test(timeout = 500)
    public void testSetId(){
        actual.setUserId(54321);
        assertEquals(54321, actual.getId());
    }
}
