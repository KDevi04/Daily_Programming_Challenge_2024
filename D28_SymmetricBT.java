import java.util.Scanner;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class SymmetricTree {

    // Function to check if two trees are mirror images of each other
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // both are null
        if (t1 == null || t2 == null) return false; // one is null, the other isn't
        
        // Check current nodes and recurse for children
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // Function to check if a tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    // Function to build the tree from input (assumes input format is valid)
    public TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        treeNodes[0] = root;

        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
                treeNodes[i] = node;
                if (i % 2 == 1) {
                    treeNodes[(i - 1) / 2].left = node;
                } else {
                    treeNodes[(i - 1) / 2].right = node;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the tree in level-order (use 'null' for missing nodes):");
        String input = sc.nextLine();
        String[] nodes = input.split(" ");

        SymmetricTree solution = new SymmetricTree();
        TreeNode root = solution.buildTree(nodes);
        
        if (solution.isSymmetric(root)) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }
        
        sc.close();
    }
}
