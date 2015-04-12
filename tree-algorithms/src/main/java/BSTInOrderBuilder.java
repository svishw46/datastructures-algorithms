import java.util.List;

/**
 * Given a sorted array, write an algorithm to create a binary search tree with minimal height.
 */
public class BSTInOrderBuilder {
    private List<Integer> sortedList;

    public BSTInOrderBuilder(List<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    public Node buildFromInOrder(int left, int right) {
        if (left > right) {//If cursors meet and start crossing in different directions.
            return null;
        }

        int middle = (left + right) / 2;
        Node root = new Node(this.sortedList.get(middle));
        root.left = buildFromInOrder(left, middle - 1);
        root.right = buildFromInOrder(middle + 1, right);

        return root;
    }
}
