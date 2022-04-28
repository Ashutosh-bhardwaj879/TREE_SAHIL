
//https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/
import java.util.*;

// * Definition for a binary tree node.
class TreeNode {
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

// ! TC O(N) SC O(N)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if (root == null)
            return ans;

        // pushing root
        st.push(root);

        // while stack is not empty
        while (!st.isEmpty()) {
            // pop top element
            TreeNode currentNode = st.pop();
            // push val of poped element
            ans.add(currentNode.val);

            if (currentNode.right != null)
                st.push(currentNode.right);

            if (currentNode.left != null)
                st.push(currentNode.left);

        }

        return ans;

    }
}