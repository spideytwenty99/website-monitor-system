


import com.websitemonitor.StrategyPattern.ComparingTextContent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextContentTest {

    ComparingTextContent textTest = new ComparingTextContent();

    @Test
    public void identicalText() {
        assertFalse(textTest.compare(
                "Hello bro",
                "Hello bro"
        ));
    }

    @Test
    public void differentText() {
        assertTrue(textTest.compare(
                "Hello",
                "World"
        ));
    }

    @Test
    public void caseDifference() {
        assertTrue(textTest.compare(
                "Hello",
                "hello"
        ));
    }

    @Test
    public void emptyStrings() {
        assertFalse(textTest.compare(
                "",
                ""
        ));;
    }

    @Test
    public void nullText() {
        try {
            textTest.compare(null, "Hello");
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
        }
    }
}