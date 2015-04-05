import static java.lang.Math.max;

/**
 * Determines the height of a tree.
 */
public class TreeHeightDeterminer {

    public int determine(Node node) {
        if (node == null) {
            return 0;
        }

        return max(determine(node.left), determine(node.right)) + 1;
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


        TreeHeightDeterminer treeHeightDeterminer = new TreeHeightDeterminer();
        int height = treeHeightDeterminer.determine(root);

        System.out.println("Height: "+ height);
    }
}
