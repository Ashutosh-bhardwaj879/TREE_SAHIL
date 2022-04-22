/**https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
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
class SumOfRootToLeafBinaryTree {
    public int sumRootToLeaf(TreeNode root) {
        int[] answer = {0};
        rootToLeaf(root,""+Integer.toString(root.val),answer);
        return answer[0];
        
    }
    private void rootToLeaf(TreeNode root,String  currentPath,int[] answer){
        
        if(root.right == null && root.left ==  null){
            //convert currentPath to deicmal value
            answer[0] += Integer.parseInt(currentPath,2);
            return;
        }
        //TC O(N) SC O(N)
        if(root.left != null)
            rootToLeaf(root.left,currentPath + Integer.toString(root.left.val),answer);
        
        if(root.right != null)
            rootToLeaf(root.right,currentPath + Integer.toString(root.right.val),answer);
        
        return;
    }
}