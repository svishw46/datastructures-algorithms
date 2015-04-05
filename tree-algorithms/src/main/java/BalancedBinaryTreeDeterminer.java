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

    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        seven.left = eight;
        eight.left = nine;

        BalancedBinaryTreeDeterminer balancedBinaryTreeDeterminer = new BalancedBinaryTreeDeterminer();
        System.out.println("Is tree balanced? " + balancedBinaryTreeDeterminer.isBalanced(root));

        //Balancing the tree.
        seven.left = null;
        eight.left = null;

        System.out.println("Is tree balanced? " + balancedBinaryTreeDeterminer.isBalanced(root));
    }
}
