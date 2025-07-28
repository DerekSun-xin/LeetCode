/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans; 

    public Solution(){
        this.ans = null; 
    }

    public boolean recurseTree(TreeNode curNode, TreeNode p, TreeNode q){
        if(curNode == null){
            return false; 
        }

        boolean left = false, mid = false, right = false; 

        left = recurseTree(curNode.left,p,q);
        right = recurseTree(curNode.right,p,q);

        if (curNode == p || curNode == q){
            mid = true;
        }

        if ((left?1:0)+(mid?1:0)+(right?1:0)==2){
            this.ans = curNode;
        }
        return left || right || mid; 
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root,p,q);
        return this.ans; 
    }
}