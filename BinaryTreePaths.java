import java.util.*;

//https://leetcode.com/problems/binary-tree-paths/
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
class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        rootToLeaf(root, "" + Integer.toString(root.val), ans);
        return ans;
    }

    private void rootToLeaf(TreeNode root, String currentPath, List<String> answer) {

        if (root.right == null && root.left == null) {
            // add currentPath to answer
            answer.add(currentPath);
            return;
        }
        // TC O(N) -- SC O(N)
        if (root.left != null)
            rootToLeaf(root.left, currentPath + "->" + Integer.toString(root.left.val), answer);

        if (root.right != null)
            rootToLeaf(root.right, currentPath + "->" + Integer.toString(root.right.val), answer);

        return;
    }
}
