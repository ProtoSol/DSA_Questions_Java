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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // Iterative Method
        // Make a Class to remeber
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maximumDepth = 0;
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int depth = pair.depth;
            maximumDepth = Math.max(maximumDepth, depth);
            // Compute the left
            if(node.left!= null){
                stack.push(new Pair(node.left, depth + 1));
            }
            // Compute the Right
            if(node.right != null){
                stack.push(new Pair(node.right, depth + 1));
            }
        }
        return maximumDepth;
    }

    // Recursive Method
        // // Base Case
        // if(root == null){
        //     return 0;
        // }
        // // Move to Left
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // int max = Math.max(left, right);
        // return max + 1;
}

class Pair{
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}