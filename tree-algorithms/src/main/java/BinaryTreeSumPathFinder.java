/**
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a
 * given value. Note that a path can start or end anywhere in the tree.
 */
public class BinaryTreeSumPathFinder {
    private int sum;

    public BinaryTreeSumPathFinder(int sum) {
        this.sum = sum;
    }

    public void findSum(Node node, int[] path, int level) {
        if (node == null) {
            return;
        }

        //Build the path.
        path[level] = node.value;

        //At each node level calculate sum. If sum equals this.sum, print the path.
        int sum = 0;
        for (int i = level; i >= 0; i--) {
            sum += path[i];

            if (sum == this.sum) {
                System.out.println("\nPATH: ");
                printPath(path, i, level);
            }
        }

        //Go left. Increment level.
        findSum(node.left, path, level + 1);
        //Go right. Increment level.
        findSum(node.right, path, level + 1);
    }

    private void printPath(int[] path, int from, int to) {
        for (int i = from; i <= to; i++) {
            System.out.print(" " + path[i] + " ");
        }
    }
}
