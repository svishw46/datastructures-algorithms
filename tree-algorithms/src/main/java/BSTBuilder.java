import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array, write an algorithm to create a binary search tree with minimal height.
 */
public class BSTBuilder {
    private List<Integer> sortedList;

    public BSTBuilder(List<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    public Node build(int left, int right) {
        if (left > right) {//If cursors meet and start crossing in different directions.
            return null;
        }

        int middle = (left + right) / 2;
        Node root = new Node(this.sortedList.get(middle));
        root.left = build(left, middle - 1);
        root.right = build(middle + 1, right);

        return root;
    }

    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<Integer>(8);
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(4);
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(7);

        BSTBuilder bstBuilder = new BSTBuilder(sortedList);
        int initialLeft = 0;
        int initialRight = sortedList.size() - 1;
        Node root = bstBuilder.build(initialLeft, initialRight);

        //In-order traversal of a BST should print in sorted order again.
        RecursiveTreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser();
        recursiveTreeTraverser.traverseInOrder(root);
    }
}
