/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while(!queue.isEmpty()){

            if(distance == k){
                break;
            }

            int size = queue.size();

            for(int i=0; i<size; i++){

                TreeNode node = queue.poll();

                //left
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                //right
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                //parent
                TreeNode parentNode = parent.get(node);

                if(parentNode != null && !visited.contains(parentNode)){
                    visited.add(parentNode);
                    queue.offer(parentNode);
                }
            }

            distance++;
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }

        return result;
    }

    public void buildParent(TreeNode node, TreeNode parentNode, Map<TreeNode, TreeNode> parent){

        if(node == null){
            return;
        }

        parent.put(node, parentNode);

        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}