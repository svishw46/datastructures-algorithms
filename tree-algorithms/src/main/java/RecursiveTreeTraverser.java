import java.util.ArrayList;
import java.util.List;

/**
 * Traverses a tree in 4 ways recursively. Pre-order, in-order, post-order and level-order.
 */
public class RecursiveTreeTraverser {

    public void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(" " + node.value);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left);
        System.out.print(" " + node.value);
        traverseInOrder(node.right);
    }

    public void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }

        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(" " + node.value);
    }

    public void traverseLevelOrder(List<Node> nodeList) {
        if (nodeList.isEmpty()) {
            return;
        }

        List<Node> nextLevelNodeList = new ArrayList<Node>();
        for (Node eachNode : nodeList) {
            System.out.print(" " + eachNode.value);

            if (eachNode.left != null) {
                nextLevelNodeList.add(eachNode.left);
            }

            if (eachNode.right != null) {
                nextLevelNodeList.add(eachNode.right);
            }
        }

        traverseLevelOrder(nextLevelNodeList);
    }

    public static void main(String[] args) {
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
