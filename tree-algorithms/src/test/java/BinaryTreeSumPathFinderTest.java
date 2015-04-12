import org.junit.Test;

public class BinaryTreeSumPathFinderTest {

    @Test
    public void testFindSum() throws Exception {
        BinaryTreeSumPathFinder binaryTreeSumPathFinder = new BinaryTreeSumPathFinder(7);

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

        TreeHeightDeterminer treeHeightDeterminer = new TreeHeightDeterminer();
        int height = treeHeightDeterminer.determineHeight(root);

        int[] path = new int[height];

        binaryTreeSumPathFinder.findSum(root, path, 0);
    }
}