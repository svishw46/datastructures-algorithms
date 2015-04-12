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
}
