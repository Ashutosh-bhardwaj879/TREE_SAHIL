import java.util.*;
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/submissions/

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

class NaryPostOrder {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        POST(root, ans);
        return ans;
    }

    private void POST(Node root, List<Integer> ans) {
        if (root == null)
            return;

        List<Node> childrens = root.children;

        for (Node currentChild : childrens) {
            POST(currentChild, ans);
        }
        // tc o(n) sc o(n)
        ans.add(root.val);
        return;

    }
}