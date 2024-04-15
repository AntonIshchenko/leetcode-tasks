public class IsValidBST {

    int maxL = -9999999;
    int maxR = -9999999;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if(root.left != null) {
            maxL = root.left.val > maxL ? root.left.val : maxL;
        }
        // maxL = root.left != null ? root.left.val > maxL ? root.left.val : maxL : maxL;
        boolean right = isValidBST(root.right);
        if(root.right != null) {
            maxR = root.right.val > maxR ? root.right.val : maxR;
        }
        // maxR = root.right != null ? root.right.val > maxR ? root.right.val : maxR : maxR;

        if((root.left != null && root.left.val >= root.val) ||
                (root.right != null && root.right.val <= root.val) ||
                (maxL > maxR)) {
            return false;
        }

        return left && right;
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
}
