package UseCases;

import entity.Post;
import junit.framework.TestCase;
import useCases.PostUseCases;

import java.util.HashMap;

public class PostUseCasesTests extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddPost() {
        PostUseCases manager = new PostUseCases(new HashMap<>(), new HashMap<>());
        manager.addPost("Helloworld!",1, "Hello World!", "test");
        String actual = manager.getPostFromId(1).getContent();
        String expected = "Hello World!";
        assertEquals("There is error in PostManager.addPost!", actual, expected);
    }

    public void testGetPostFromId() {
        PostUseCases manager = new PostUseCases(new HashMap<>(), new HashMap<>());
        manager.addPost("Helloworld!",1, "Hello World!", "test");
        manager.addPost("Helloworld!",1, "Hello World!", "test");
        String actual = manager.getPostFromId(2).getContent();
        String expected = "Hello World!";
        assertEquals("There is error in PostManager.getPostFromId!", actual, expected);
    }

    public void testShowPost() {
        PostUseCases manager = new PostUseCases(new HashMap<>(), new HashMap<>());
        manager.addPost("Helloworld!",1, "Hello World!", "test");
        manager.addPost("Helloworld!",1, "Hello World!", "test");
        Post post = manager.getPostFromId(2);
        String actual = manager.showPost(2);
        String expected = "time:" + post.getTime() +"\n"+
                "content:" + post.getContent() + "\n" +
                "id:" + post.getId() + "\n" +
                "sender:" + post.getUserId();
        assertEquals("There is error in PostManager.showPost!", actual, expected);
    }

}