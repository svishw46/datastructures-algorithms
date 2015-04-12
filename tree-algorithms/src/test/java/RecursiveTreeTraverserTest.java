import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecursiveTreeTraverserTest {

    @Test
    public void testMain() throws Exception {
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
        System.out.println("\nPRE-ORDER ROOT LEFT RIGHT");
        recursiveTreeTraverser.traversePreOrder(root);
        System.out.println("\nIN-ORDER LEFT ROOT RIGHT");
        recursiveTreeTraverser.traverseInOrder(root);
        System.out.println("\nPOST-ORDER LEFT RIGHT ROOT");
        recursiveTreeTraverser.traversePostOrder(root);

        System.out.println("\nLEVEL-ORDER");
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(root);
        recursiveTreeTraverser.traverseLevelOrder(nodeList);
    }
}