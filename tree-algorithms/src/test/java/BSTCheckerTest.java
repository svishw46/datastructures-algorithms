import org.junit.Test;

import static org.junit.Assert.*;

public class BSTCheckerTest {

    @Test
    public void testIsBST() throws Exception {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        BSTChecker bstChecker = new BSTChecker();
        boolean isBst = bstChecker.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("is BST? " + isBst);
        assertFalse(isBst);

        root = new Node(4);
        root.left = three;
        root.right = five;

        three.left = two;
        three.right = four;

        two.left = null;
        two.right = null;

        isBst = bstChecker.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertTrue(isBst);
    }
}