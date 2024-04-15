public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        swapNodes(root);
        return root;
    }

    private void swapNodes(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null) {
            swapNodes(left);
        }
        if (right != null) {
            swapNodes(right);
        }
        TreeNode tmp = root.right;

        root.right = root.left;
        root.left = tmp;
    }


    public class TreeNode {
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
}
