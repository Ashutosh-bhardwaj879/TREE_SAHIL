import java.util.*;

// ?Definition for a binary tree node.
class TreeNodeA {
    int val;
    TreeNodeA left;
    TreeNodeA right;

    TreeNodeA(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNodeA root, TreeNodeA target, int k) {
        // ! TC-O(N) SC-O(N)
        HashMap<TreeNodeA, TreeNodeA> parentMap = findParents(root);
        return findNodesAtKDistance(root, target, k, parentMap);
    }

    private List<Integer> findNodesAtKDistance(TreeNodeA root, TreeNodeA target, int k,
            HashMap<TreeNodeA, TreeNodeA> parentMap) {
        HashSet<TreeNodeA> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<Integer>();
        iterateTree(target, k, parentMap, visited, ans);
        return ans;
    }

    private void iterateTree(TreeNodeA current, int k, HashMap<TreeNodeA, TreeNodeA> parentMap,
            HashSet<TreeNodeA> visited,
            List<Integer> ans) {
        // !if the set contains the parent beforehand no need to add it...it will make
        // !infinite recursion
        if (current == null || visited.contains(current))
            return;

        visited.add(current);
        // !if k hits 0 that means tht is the ans no need to make extra call now
        if (k == 0) {
            ans.add(current.val);
            return;
        }
        // left call
        iterateTree(current.left, k - 1, parentMap, visited, ans);
        // right call
        iterateTree(current.right, k - 1, parentMap, visited, ans);
        // !parentMap.get(current) --> get parent from parent map and make a call
        iterateTree(parentMap.get(current), k - 1, parentMap, visited, ans);

        return;

    }

    private HashMap<TreeNodeA, TreeNodeA> findParents(TreeNodeA root) {
        HashMap<TreeNodeA, TreeNodeA> parentMap = new HashMap<>();
        iterateForParent(root, null, parentMap);
        return parentMap;
    }

    private void iterateForParent(TreeNodeA currentNode, TreeNodeA currentParent,
            HashMap<TreeNodeA, TreeNodeA> parentMap) {
        if (currentNode == null)
            return;

        parentMap.put(currentNode, currentParent);
        // left call
        iterateForParent(currentNode.left, currentNode, parentMap);
        // right call
        iterateForParent(currentNode.right, currentNode, parentMap);
        return;
    }

}
