import com.sun.source.tree.Tree;

import java.util.LinkedList;

public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long leftBound, long rightBound) {
        if (node == null) {
            return true;
        }
        if (node.val >= rightBound && node.val <= leftBound) {
            return false;
        }

        return isValid(node.left, leftBound, node.val) && isValid(node.right, node.val, rightBound);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 5;
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        boolean validBST = new ValidateBinarySearchTree().isValidBST(tree);
        System.err.println(validBST);
    }
}
