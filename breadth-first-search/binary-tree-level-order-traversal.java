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
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);  
        Queue<TreeNode> queue = new ArrayDeque<>(); 
        queue.add(root); 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rootLevelList = new ArrayList<>();
        rootLevelList.add(root.val);
        res.add(rootLevelList);  
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll(); 
            // Iterate through cur's neighbors 
            List<Integer> curLevelList = new ArrayList<>(); 
            if (cur.left != null && !visited.contains(cur.left)){
                visited.add(cur.left); 
                curLevelList.add(cur.left.val);
                queue.add(cur.left); 
            }
            if (cur.right != null && !visited.contains(cur.right)){
                visited.add(cur.right); 
                curLevelList.add(cur.right.val); 
                queue.add(cur.right); 
            }
            if (curLevelList.size() !=0){
                res.add(curLevelList); 
            }
        }
        return res; 
    }
}