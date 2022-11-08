
import Layer3.Commands.CLI;
import org.junit.*;

public class CLITests {
    static CLI actual;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValidInput() {
        actual = new CLI();
    }
}