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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result; // Edge Case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // Maintaining values
            int size = queue.size();
            double sum = 0;
            // int count = 0;
            // Calc the nodes and get the sum of nodes on the level
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum = sum + node.val;
                // count++;
                // Traverse to next Level
                if(node.left != null) queue.offer(node.left);
                if(node.right!= null) queue.offer(node.right);
            }
            // Add to the result list
            result.add(sum/size /*replaced count with size*/);
        }
        // Return the List
        return result;
    }
}