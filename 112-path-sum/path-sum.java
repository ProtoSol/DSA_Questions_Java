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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the root is null, return false
        if (root == null) {
            return false;
        }
        // If it's a leaf node and the remaining sum equals the node's value
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        // Recursively check left and right subtrees
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }
}