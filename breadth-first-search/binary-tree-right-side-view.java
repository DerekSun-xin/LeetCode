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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>(); 
        }
        List<Integer> res = new ArrayList<>(); 
        Queue<TreeNode> queue = new ArrayDeque<>(); 
        queue.add(root); 
        
        while(!queue.isEmpty()){
            int queueSize = queue.size(); 
            for(int i = 0; i < queueSize; i++){
                TreeNode cur = queue.poll(); 
                if (i == queueSize-1){
                    res.add(cur.val); 
                }
                if (cur.left != null){
                    queue.add(cur.left); 
                }
                if (cur.right != null){
                    queue.add(cur.right); 
                }
            }
        }
        return res; 
    }
}