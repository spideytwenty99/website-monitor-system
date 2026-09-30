import com.websitemonitor.StrategyPattern.ComparingContentSize;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContentSizeTest {

    ComparingContentSize sizeTest = new ComparingContentSize();

    @Test
    public void sameSizeDifferentText(){
        assertFalse(sizeTest.compare("Hello", "World"));
    }

    @Test
    public void differentSize(){
        assertTrue(sizeTest.compare("Hello","Hello World"));
    }


    @Test
    public void emptyStrings() {
        assertFalse(sizeTest.compare("", ""));
    }

    @Test
    public void nullContent(){
        try {
            sizeTest.compare(null, "Hello");
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
        }
    }

}
