//TC - O(M+N)
//SC - O(MIN(M,N))
//https://leetcode.com/problems/merge-two-binary-trees/
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
class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTwoTrees(root1, root2);
    }

    private TreeNode mergeTwoTrees(TreeNode t1, TreeNode t2) {
        // no need to write this although
        // if(t1 == null && t2 == null)
        // return null;

        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        TreeNode newNode = new TreeNode(t1.val + t2.val);

        newNode.left = mergeTwoTrees(t1.left, t2.left);

        newNode.right = mergeTwoTrees(t1.right, t2.right);

        return newNode;

        // TC - O(M+N)
        // SC - O(MIN(M,N))

    }
}