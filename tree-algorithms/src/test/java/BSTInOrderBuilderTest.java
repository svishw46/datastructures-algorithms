import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BSTInOrderBuilderTest {

    @Test
    public void testBuildFromInOrder() throws Exception {
        List<Integer> sortedList = new ArrayList<Integer>(8);
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);

        BSTInOrderBuilder bstInOrderBuilder = new BSTInOrderBuilder(sortedList);
        int initialLeft = 0;
        int initialRight = sortedList.size() - 1;
        Node root = bstInOrderBuilder.buildFromInOrder(initialLeft, initialRight);

        //In-order traversal of a BST should print in sorted order again.
        RecursiveTreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser();
        recursiveTreeTraverser.traverseInOrder(root);
    }
}