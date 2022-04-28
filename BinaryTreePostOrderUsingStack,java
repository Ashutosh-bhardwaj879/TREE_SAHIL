//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //tc - o(n)  sc-o(h)
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> postOrder = new Stack<>();
        
        if(root == null)
            return ans;
        
        //pushing root
        postOrder.push(root);
        
        //while stack is not empty
        while(!postOrder.isEmpty()){
            //pop top element       
            TreeNode currentNode = postOrder.pop();
            // push val of poped element
            ans.add(currentNode.val);
            
            /*
             * left-right-node
             * reverse order node then right then left 
             * (for processing right first put left first then right secnd in stack)
             * reverse stack
            */
            if(currentNode.left!=null)
                postOrder.push(currentNode.left);
            
            if(currentNode.right != null)
                postOrder.push(currentNode.right);
         
        }
        
        Collections.reverse(ans);
        return ans;
    }
}