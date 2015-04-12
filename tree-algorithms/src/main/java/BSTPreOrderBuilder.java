import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Builds a BST from a pre-order.
 */
public class BSTPreOrderBuilder {

    public Node buildFromPreOrder(List<Integer> integerList) {
        Stack<Node> stack = new Stack<Node>();

        int left, right;
        Node root = new Node(integerList.get(0));
        stack.push(root);

        for (int i = 1; i < integerList.size(); i++) {
            if(i+1 == integerList.size()) {
                int lastVal = integerList.get(i);

                Node stackTop = stack.peek();

                if(stackTop.value < lastVal) {
                    Node addToRight = new Node(lastVal);
                    stackTop.right = addToRight;
                } else {
                    Node addToLeft = new Node(lastVal);
                    stackTop.left = addToLeft;
                }

                break;
            }

            left = integerList.get(i);
            right = integerList.get(i+1);


            if(left > right) {
                Node addToLeft = stack.peek();
                addToLeft.left = new Node(left);
                stack.push(addToLeft.left);
            } else {
                Node addToLeft = stack.peek();
                addToLeft.left = new Node(left);
                stack.push(addToLeft.left);

                Node addToRight = null;
                while(!stack.isEmpty() && right > stack.peek().value) {
                    addToRight = stack.pop();
                }

                addToRight.right = new Node(right);
                i++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BSTPreOrderBuilder bstPreOrderBuilder = new BSTPreOrderBuilder();
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(6);
        integerList.add(4);
        integerList.add(3);
        integerList.add(5);
        integerList.add(7);

        Node root = bstPreOrderBuilder.buildFromPreOrder(integerList);

        RecursiveTreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser();
        recursiveTreeTraverser.traversePreOrder(root);
    }
}
