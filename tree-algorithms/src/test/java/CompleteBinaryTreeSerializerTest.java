import org.junit.Test;

import java.io.IOException;

public class CompleteBinaryTreeSerializerTest {

    @Test
    public void testSerializeDeserialize() throws IOException, ClassNotFoundException {
        Node root = new Node(6);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node seven = new Node(7);

        root.left = four;
        root.right = seven;

        four.left = three;
        four.right = five;

        seven.left = new Node(11);
        seven.right = new Node(12);

        RecursiveTreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser();
        System.out.println("BEFORE SERIALIZING");
        recursiveTreeTraverser.traverseInOrder(root);

        CompleteBinaryTreeSerializer completeBinaryTreeSerializer = new CompleteBinaryTreeSerializer();
        byte[] byteArray = completeBinaryTreeSerializer.serialize(root);

        root = completeBinaryTreeSerializer.deSerialize(byteArray);

        System.out.println("\nAFTER DESERIALIZING");
        recursiveTreeTraverser.traverseInOrder(root);
    }
}