//https://www.geeksforgeeks.org/check-if-two-nodes-in-a-binary-tree-are-siblings/
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

class SiblingInBinaryTree {
    public boolean isSibling(TreeNode root, int x, int y) {
        // tc:o(n) sc:o(h)
        int[] parents = new int[2];
        int[] levels = new int[2];
        TreeNode currentParent = new TreeNode(-1);
        int currentLevel = 0;
        findParentsAndLevels(root, currentParent, currentLevel, x, y, parents, levels);
        return (levels[0] == levels[1] && parents[0] == parents[1]);
    }

    private void findParentsAndLevels(TreeNode root, TreeNode currentParent, int currentLevel, int x, int y,
            int[] parents, int[] levels) {

        if (root == null)
            return;

        if (x == root.val) {
            parents[0] = currentParent.val;
            levels[0] = currentLevel;
            return;
        }

        if (root.val == y) {
            parents[1] = currentParent.val;
            levels[1] = currentLevel;
            return;
        }

        findParentsAndLevels(root.left, root, currentLevel + 1, x, y, parents, levels);
        findParentsAndLevels(root.right, root, currentLevel + 1, x, y, parents, levels);

        return;

    }
}