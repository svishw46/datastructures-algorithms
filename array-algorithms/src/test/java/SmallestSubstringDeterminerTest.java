import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestSubstringDeterminerTest {

    @Test
    public void testDetermine() throws Exception {
        SmallestSubstringDeterminer smallestSubstringDeterminer = new SmallestSubstringDeterminer();

        String result = smallestSubstringDeterminer.determine("this is a test string", "tist");
        assertEquals("t stri", result);
    }
}