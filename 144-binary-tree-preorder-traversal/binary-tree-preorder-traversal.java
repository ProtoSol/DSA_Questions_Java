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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        // Check for null
        if(root == null) return result;
        // Push the First Node
        stack.push(root);
        // Perform the While loop
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val); // Store the value
            // We push right first then left
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return result;
    }
}

class Pair{

}

/*
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }
    private void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        result.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
*/