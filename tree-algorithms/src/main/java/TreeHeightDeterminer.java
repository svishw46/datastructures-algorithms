import static java.lang.Math.max;

/**
 * Determines the height of a tree.
 */
public class TreeHeightDeterminer {

    public int determineHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return max(determineHeight(node.left), determineHeight(node.right)) + 1;
    }
}
