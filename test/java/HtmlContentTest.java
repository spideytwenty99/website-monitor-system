import com.websitemonitor.StrategyPattern.ComparingHtmlContent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HtmlContentTest {

    ComparingHtmlContent contentTest = new ComparingHtmlContent();

    @Test
    public void identicalHtml() {
        assertFalse(contentTest.compare(
                "<h1>Hello</h1>",
                "<h1>Hello</h1>"
        ));
    }

    @Test
    public void differentHtmlSameText() {
        assertTrue(contentTest.compare(
                "<h1>Hello</h1>",
                "<h2>Hello</h2>"
        ));
    }

    @Test
    public  void differentHtmlDifferentText(){
        assertTrue(contentTest.compare("<h1>Hello bro</h1>", "<p>Bye</p>"));
    }
    @Test
    public void nullHtmlShouldThrowException() {
        try {
            contentTest.compare(null, "Hello");
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
        }
    }
}