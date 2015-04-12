import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * If the given Binary Tree is Binary Search Tree, we can store it by either storing preorder or postorder traversal.
 * In case of Binary Search Trees, only preorder or postorder traversal is sufficient to store structure information.
 */
public class BSTSerializer {
    private List<Integer> integerList = new ArrayList<Integer>();

    public byte[] serialize(Node root) throws IOException {
        //Traverse inOrder.
        traverseInOrder(root);

        //Serialize to bytes.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this.integerList);

        this.integerList = null;

        return byteArrayOutputStream.toByteArray();
    }

    public Node deSerialize(byte[] bytes) throws IOException, ClassNotFoundException {
        //DeSerialize to bytes.
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        this.integerList = (List) objectInputStream.readObject();

        //Build BST from inOrder.
        BSTInOrderBuilder bstInOrderBuilder = new BSTInOrderBuilder(this.integerList);
        Node root = bstInOrderBuilder.buildFromInOrder(0, this.integerList.size() - 1);

        return root;
    }

    private void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left);
        this.integerList.add(node.value);
        traverseInOrder(node.right);
    }
}
