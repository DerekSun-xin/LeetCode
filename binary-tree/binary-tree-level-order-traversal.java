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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        // Breadth First Search 
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root); 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rootLevelList = new ArrayList<>();
        rootLevelList.add(root.val);
        res.add(rootLevelList);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevelList = new ArrayList<>(); 
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    curLevelList.add(cur.left.val);
                    queue.add(cur.left); 
                }
                if (cur.right != null){
                    curLevelList.add(cur.right.val); 
                    queue.add(cur.right); 
                }
            }
        
            if (curLevelList.size() != 0){
                res.add(curLevelList); 
            }
        }
        return res; 
    }
}