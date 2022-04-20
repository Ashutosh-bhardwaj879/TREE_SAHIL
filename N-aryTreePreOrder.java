import java.util.*;
//https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
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
//TC = O(N)  SC-O(N)
class NaryPreOrderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }

    private void preOrder(Node root, List<Integer> ans) {

        if (root == null)
            return;

        ans.add(root.val);

        List<Node> childrens = root.children;

        for (Node currentChild : childrens)
            preOrder(currentChild, ans);

        return;

    }
}