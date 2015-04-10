import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Binary Tree is complete if all levels are completely filled except possibly the last level and all nodes of last
 * level are as left as possible (Binary Heaps are complete Binary Tree). For a complete Binary Tree, level order
 * traversal is sufficient to store the tree. We know that the first node is root, next two nodes are nodes of next
 * level, next four nodes are nodes of 2nd level and so on.
 */
public class CompleteBinaryTreeSerializer {
    private List<Integer> integerList = new ArrayList<Integer>();

    public byte[] serialize(Node root) throws IOException {
        //Traverse levelOrder.
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(root);
        traverseLevelOrder(nodeList);

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

        //Build BST from levelOrder.
        BSTLevelOrderBuilder bstLevelOrderBuilder = new BSTLevelOrderBuilder();
        Node root = bstLevelOrderBuilder.buildFromLevelOrder(this.integerList);

        return root;
    }

    public void traverseLevelOrder(List<Node> nodeList) {
        if (nodeList.isEmpty()) {
            return;
        }

        List<Node> nextLevelNodeList = new ArrayList<Node>();
        for (Node eachNode : nodeList) {
            this.integerList.add(eachNode.value);

            if (eachNode.left != null) {
                nextLevelNodeList.add(eachNode.left);
            }

            if (eachNode.right != null) {
                nextLevelNodeList.add(eachNode.right);
            }
        }

        traverseLevelOrder(nextLevelNodeList);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
