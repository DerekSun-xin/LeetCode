/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool helper(TreeNode* root, int val){
        //Never forget to add the base case
        if(root==NULL){
            return true;
        }
        //pre-order is the best here
        if(root->val!=val){
            return false;
        }
        bool left = helper(root->left, val);
        if(left==false){
            return false;
        }
        
        return helper(root->right, val); 
    }
    
    bool isUnivalTree(TreeNode* root) {
        return helper(root,root->val); 
    }
};