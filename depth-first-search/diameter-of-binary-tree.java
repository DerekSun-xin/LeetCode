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
    Integer diameter = 0; 
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root); 
        return this.diameter; 
    }

    int getDepth(TreeNode root){
        if (root == null){
            return 0; 
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right); 
        if (leftDepth + rightDepth > this.diameter){
            this.diameter = leftDepth + rightDepth; 
        }
        return 1 + Math.max(leftDepth, rightDepth); 
    }
}