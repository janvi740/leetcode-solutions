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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);

        return dfs(root, 0L, targetSum, prefixCount);
    }

    public int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixCount){

        if (node == null) {
            return 0;
        }

        currentSum += node.val;

        int count = prefixCount.getOrDefault(currentSum - targetSum, 0);

        prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0)+1);

        count += dfs(node.left, currentSum, targetSum, prefixCount);
        count += dfs(node.right, currentSum, targetSum, prefixCount);

        prefixCount.put(currentSum, prefixCount.get(currentSum) - 1);

        return count;
    }
}