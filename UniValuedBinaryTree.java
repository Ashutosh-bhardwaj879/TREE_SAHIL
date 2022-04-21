/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// https://leetcode.com/problems/univalued-binary-tree/
class UniValuedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        // tc o(n) sc : o(h)
        return UniValued(root, root.val);
    }

    private boolean UniValued(TreeNode root, int val) {
        if (root == null)
            return true;

        if (root.val != val)
            return false;

        boolean leftCall = UniValued(root.left, val);
        boolean rightCall = UniValued(root.right, val);

        return leftCall && rightCall;
    }
}