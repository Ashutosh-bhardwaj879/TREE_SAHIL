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
//https://leetcode.com/problems/same-tree/
class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // tc o(min(m,n)) sc o(min(m,n))
        if (p == null && q == null)
            return true;
        // this condition will take care of all the things
        // example say if left of p is null or right of q is null then that means
        // there is no chance of getting equal tree and ya we are also checking the val
        // at each place
        if (p == null || q == null || p.val != q.val)
            return false;

        Boolean leftCall = isSameTree(p.left, q.left);
        Boolean rightCall = isSameTree(p.right, q.right);

        return leftCall && rightCall;
    }
}