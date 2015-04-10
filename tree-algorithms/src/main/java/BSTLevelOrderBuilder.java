import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Builds a BinaryTree from the given level order.
 */
public class BSTLevelOrderBuilder {

    public Node buildFromLevelOrder(List<Integer> integerList) {
        //1. Add the first value in the array as the root.
        Queue<Node> nodeQueue = new LinkedList<Node>();
        Node root = new Node(integerList.get(0));
        nodeQueue.add(root);

        //2. Save the root to be returned.
        Node returnRoot = root;

        int left, right;
        for (int i = 0; i < integerList.size(); i++) {
            left = (2 * i) + 1; //Get the left index.
            right = left + 1; //Get the right index.

            if (!nodeQueue.isEmpty()) {
                root = nodeQueue.poll();
                if (left < integerList.size()) { // index check. There is no left child if its beyond array size.
                    root.left = new Node(integerList.get(left)); // Add to the left.
                    nodeQueue.add(root.left);
                }
                if (right < integerList.size()) { // index check. There is no right child if its beyond array size.
                    root.right = new Node(integerList.get(right)); // Add to the right.
                    nodeQueue.add(root.right);
                }
            }
        }

        return returnRoot;
    }
}
