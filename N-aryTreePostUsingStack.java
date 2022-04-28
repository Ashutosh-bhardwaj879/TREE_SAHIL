import java.util.*;

//!https://leetcode.com/problems/n-ary-tree-postorder-traversal/submissions/
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        if (root == null)
            return ans;

        // pushing root
        st.push(root);

        // while stack is not empty
        while (!st.isEmpty()) {
            // pop top element
            Node currentNode = st.pop();
            // push val of poped element
            ans.add(currentNode.val);

            List<Node> children = currentNode.children;

            // left to right
            for (int i = 0; i < children.size(); i++) {
                Node currentChild = children.get(i);
                st.push(currentChild);
            }
            // *SC - O(h) -- hiehght of binary tree
            // *TC - o(n)
        }
        Collections.reverse(ans);
        return ans;
    }
}