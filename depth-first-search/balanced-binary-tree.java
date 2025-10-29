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
    boolean isBalanced = true; 

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return this.isBalanced; 
    }

    int getDepth(TreeNode root){
        if (root == null){
            return 0; 
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right); 
        if (Math.abs(rightDepth - leftDepth) > 1){
            this.isBalanced = false; 
        }
        return 1 + Math.max(leftDepth, rightDepth); 
    }
}