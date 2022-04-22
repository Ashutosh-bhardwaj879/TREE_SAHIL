import java.util.*;
//https://leetcode.com/problems/leaf-similar-trees/
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
class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // tc o(n+m)
        // sc o(min(n,m))
        List<Integer> leavesOfT1 = new ArrayList<>();
        List<Integer> leavesOfT2 = new ArrayList<>();

        findLeaves(root1, leavesOfT1);
        findLeaves(root2, leavesOfT2);

        return leavesOfT1.equals(leavesOfT2);
    }

    private void findLeaves(TreeNode root, List<Integer> leaves) {
        // putting this consition bcoz we are making random calls to left \
        // and right nodes without any check
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);

        return;

    }
}