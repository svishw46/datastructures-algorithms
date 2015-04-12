import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to find the 'next' node(in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */
public class NextNodeInOrderFinder {
    private List<Integer> integerList = new ArrayList<Integer>(2);

    public int findSuccessor(Node node, int value) {
        findSuccessorRecursive(node, value);

        return this.integerList.size() == 2 ? this.integerList.get(1) : -1;
    }

    private void findSuccessorRecursive(Node node, int value) {
        if (node == null) {
            return;
        }

        //Find in leftSubTree.
        findSuccessorRecursive(node.left, value);

        //If there is already a value that matched, node.value should be
        //the successor.
        if (this.integerList.size() == 1) {
            this.integerList.add(node.value);
        }

        //Add the value that matched.
        if (node.value == value) {
            this.integerList.add(node.value);
        }

        findSuccessorRecursive(node.right, value);
    }
}
