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
    public int minDepth(TreeNode root) {
        // Base Case
        if(root == null){
            return 0;
        }
        // Traverse
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // Conditions
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1 + rightDepth;
        if(root.right == null)
            return 1 + leftDepth;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}