import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Implement a function to check if a binary tree is balanced. For the purpose of this question, a balanced tree
 * is defined to be a tree such that the heights of the two subtrees of any node never differ more than one.
 */
public class BalancedBinaryTreeDeterminer {

    public boolean isBalanced(Node node) {
        int height = isBalancedRecursive(node);

        return !(height == -1);
    }

    private int isBalancedRecursive(Node node) {
        if (node == null) {
            return 0;
        }

        //At node's left subtree.
        int leftSubTreeHeight = isBalancedRecursive(node.left);
        if (leftSubTreeHeight == -1) { //Short circuit.
            return -1; //Not balanced.
        }

        //At node's right subtree.
        int rightSubTreeHeight = isBalancedRecursive(node.right);
        if (rightSubTreeHeight == -1) { //Short circuit.
            return -1; //Not balanced.
        }

        //At each node.
        int heightDiff = abs(leftSubTreeHeight - rightSubTreeHeight);
        if (heightDiff > 1) {
            return -1; //Not balanced.
        } else { // Return the height. Similar to {@link TreeHeightDeterminer}.
            return max(leftSubTreeHeight, rightSubTreeHeight) + 1;
        }
    }
}
