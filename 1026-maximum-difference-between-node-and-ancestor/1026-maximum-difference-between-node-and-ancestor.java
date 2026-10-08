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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode node, int maxValue, int minValue){
        if(node == null){
            return maxValue - minValue;
        }

        maxValue = Math.max(maxValue, node.val);
        minValue = Math.min(minValue, node.val);

        int left = dfs(node.left, maxValue, minValue);
        int right = dfs(node.right, maxValue, minValue);

        return Math.max(left, right);
    }
}