import org.junit.Test;

import static org.junit.Assert.*;

public class InplaceDuplicatesRemoverTest {

    @Test
    public void testRemoveDuplicates() throws Exception {
        InplaceDuplicatesRemover inplaceDuplicatesRemover = new InplaceDuplicatesRemover();

        int[] arr = new int[9];
        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 8;
        arr[3] = 5;
        arr[4] = 9;
        arr[5] = 9;
        arr[6] = 9;
        arr[7] = 10;
        arr[8] = 10;

        arr = inplaceDuplicatesRemover.removeDuplicates(arr);
    }
}