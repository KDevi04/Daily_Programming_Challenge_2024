import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeLCA {

    // Function to find the Lowest Common Ancestor (LCA)
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        // If both left and right are non-null, this is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null subtree
        return (left != null) ? left : right;
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

    // Function to find a node by its value
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return findNode(root.left, val);
        } else {
            return findNode(root.right, val);
        }
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

        System.out.println("Enter the value of the first node (p):");
        int pVal = sc.nextInt();

        System.out.println("Enter the value of the second node (q):");
        int qVal = sc.nextInt();

        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);

        if (p == null || q == null) {
            System.out.println("Both nodes must exist in the tree.");
        } else {
            TreeNode lca = findLCA(root, p, q);
            if (lca != null) {
                System.out.println("The Lowest Common Ancestor of " + pVal + " and " + qVal + " is: " + lca.val);
            } else {
                System.out.println("No common ancestor found.");
            }
        }

        sc.close();
    }
}
