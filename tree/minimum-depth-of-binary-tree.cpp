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
    int minDepth(TreeNode* root) {
       return height(root);
        
       
    }
    
    int height(TreeNode* root){
        if(root!=NULL){
            if(root->left!=NULL && root->right!=NULL){
                return 1+min(height(root->left),height(root->right));
            }else if(root->left==NULL && root->right!=NULL){
                return 1+height(root->right);
            }else if(root->right==NULL && root->left!=NULL){
                return 1+height(root->left);
            }else{
                return 1;
            }
           
        }
        return 0;
    }
};