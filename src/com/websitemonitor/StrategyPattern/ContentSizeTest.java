package com.websitemonitor.StrategyPattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContentSizeTest {

    ComparingContentSize sizeTest = new ComparingContentSize();

    @Test
    public void sameSize(){
        assertFalse(sizeTest.compare("Hello", "World"));
    }

    @Test
    public void differentSize(){
        assertTrue(sizeTest.compare("Hello","Hello World"));
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
