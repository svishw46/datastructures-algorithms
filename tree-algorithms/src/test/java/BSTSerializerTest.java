import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTSerializerTest {

    @Test
    public void testSerializeDeserialize() throws Exception {
        Node root = new Node(6);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node seven = new Node(7);

        root.left = four;
        root.right = seven;

        four.left = three;
        four.right = five;

        RecursiveTreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser();
        System.out.println("BEFORE SERIALIZING");
        recursiveTreeTraverser.traverseInOrder(root);

        BSTSerializer bstSerializer = new BSTSerializer();
        byte[] byteArray = bstSerializer.serialize(root);

        root = bstSerializer.deSerialize(byteArray);

        System.out.println("\nAFTER DESERIALIZING");
        recursiveTreeTraverser.traverseInOrder(root);
    }
}