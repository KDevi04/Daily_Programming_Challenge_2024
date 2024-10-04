import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTree {

    // Function to check if the tree is a valid BST
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function with boundaries for min and max allowed values
    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }

    // Function to insert nodes into the tree
    public static TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    // Driver function for user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = null;
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();

        System.out.println("Enter the node values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insertNode(root, val);
        }

        if (isValidBST(root)) {
            System.out.println("The tree is a valid Binary Search Tree.");
        } else {
            System.out.println("The tree is NOT a valid Binary Search Tree.");
        }

        sc.close();
    }
}
