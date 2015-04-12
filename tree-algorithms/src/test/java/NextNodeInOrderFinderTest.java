import org.junit.Test;

import static org.junit.Assert.*;

public class NextNodeInOrderFinderTest {

    @Test
    public void testFindSuccessor() throws Exception {
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

        RecursiveTreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser();
        recursiveTreeTraverser.traverseInOrder(root);

        NextNodeInOrderFinder nextNodeInOrderFinder = new NextNodeInOrderFinder();
        int successor = nextNodeInOrderFinder.findSuccessor(root, 2);

        System.out.println(" Successor: " + successor);
    }
}