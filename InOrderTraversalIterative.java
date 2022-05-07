
//! https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
import java.util.*;

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

class IterativeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();

        if (root == null)
            return ans;

        // process left subtree
        addLeftSubTree(root, st);

        while (!st.isEmpty()) {
            // add the node in ans
            TreeNode currentNode = st.pop();
            ans.add(currentNode.val);
            // process right calls
            if (currentNode.right != null)
                addLeftSubTree(currentNode.right, st);
        }
        return ans;
    }

    private void addLeftSubTree(TreeNode currentNode, Stack<TreeNode> st) {
        st.push(currentNode);

        while (currentNode.left != null) {
            st.push(currentNode.left);
            currentNode = currentNode.left;
        }
    }
}
