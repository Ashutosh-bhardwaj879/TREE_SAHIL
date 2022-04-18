
//Definition for a binary tree node.
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

class HeightBinaryTree {
    public static int maxDepth(TreeNode root) {
        return height(root);
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;

        int leftChildHeight = 1 + height(root.left);
        int rightChildHeight = 1 + height(root.right);

        return Math.max(leftChildHeight, rightChildHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(maxDepth(root));
    }
}