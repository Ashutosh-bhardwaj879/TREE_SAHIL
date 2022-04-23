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
/**
 * ! its like isSameTree but calls are different
 * !watch carefully calls are for left and right nodes
 * ?https://leetcode.com/problems/symmetric-tree/
 */
class SysmmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        Boolean leftCall = isSameTree(p.left, q.right);
        Boolean rightCall = isSameTree(p.right, q.left);

        return leftCall && rightCall;
    }
}