/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class BSTChecker {

    /**
     * MIN-MAX approach.
     *
     *      (Integer.MIN_VALUE)2(Integer.MAX_VALUE)
     *                      /     \
     * (Integer.MIN_VALUE)1(2)    (2)3(Integer.MAX_VALUE)
     *
     * Psuedo-code:
     * 1. For null, return true as there is no left or right subtree.
     * 2. If at any node, BST property violates return false.
     * 3. Recursively call left and right subtree.
     * 4. For leftSubTree update max. For rightSubTree update min.
     * 5. If at any node, it's left or right subtree is not a BST, return false.
     */
    public boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true; //There is no left or right subtree to compare. So we return true. So that it goes bottom up.
        }

        //For leftSubTree, node.value < min will always be false. It's the node.value > max that
        //could be true or false. Vice versa for rightSubtree.
        if (node.value < min || node.value > max) {
            return false;
        }

        //If at any node, leftSubTree or the rightSubTree is not a BST, return false.
        //Don't go further up.
        if (!isBST(node.left, min, node.value) || !isBST(node.right, node.value, max)) {
            return false;
        }

        return true;
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

        BSTChecker bstChecker = new BSTChecker();
        boolean isBst = bstChecker.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("is BST? " + isBst);

        root = new Node(4);
        root.left = three;
        root.right = five;

        three.left = two;
        three.right = four;

        two.left = null;
        two.right = null;

        isBst = bstChecker.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("is BST? " + isBst);
    }
}
