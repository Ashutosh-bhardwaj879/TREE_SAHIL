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
// https://leetcode.com/problems/sum-of-left-leaves/
class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        // tc o(n) sc o(h)
        return sumLeftLeaves(root, false);
    }

    private int sumLeftLeaves(TreeNode root, Boolean onLeftLeaf) {
        // since we are making left and right calls without chekcing
        // we put this base condition here
        if (root == null)
            return 0;

        if (root.right == null && root.left == null) {
            if (onLeftLeaf == true)
                return root.val;
            else
                return 0;
        }
        // since left call thats why true is passed
        int leftNodeCall = sumLeftLeaves(root.left, true);
        // since right call we won't add it
        int rightNodeCall = sumLeftLeaves(root.right, false);

        return (leftNodeCall + rightNodeCall);

    }
}
