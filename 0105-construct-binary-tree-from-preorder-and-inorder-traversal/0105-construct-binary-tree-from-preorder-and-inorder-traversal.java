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
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length-1, map);
    }

    private TreeNode build(int[] preorder, int instart, int inend, Map<Integer, Integer> map){

        if(instart > inend){
            return null;
        }

        int rootVal = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        root.left = build(preorder, instart, inIndex-1, map);
        root.right = build(preorder, inIndex+1, inend, map);

        return root;
    }
}