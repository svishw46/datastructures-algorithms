import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBinaryTreeDeterminerTest {

    @Test
    public void testIsBalanced() throws Exception {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        seven.left = eight;
        eight.left = nine;

        BalancedBinaryTreeDeterminer balancedBinaryTreeDeterminer = new BalancedBinaryTreeDeterminer();
        System.out.println("Is tree balanced? " + balancedBinaryTreeDeterminer.isBalanced(root));
        assertFalse(balancedBinaryTreeDeterminer.isBalanced(root));

        //Balancing the tree.
        seven.left = null;
        eight.left = null;

        assertTrue(balancedBinaryTreeDeterminer.isBalanced(root));
    }
}