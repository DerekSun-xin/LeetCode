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
    string tree2str(TreeNode* root) {
        if(root!=NULL){

            string ret = "";
            ret+=to_string(root->val);
            //Case 1: both children exist
            if(root->left!=NULL && root->right!=NULL){
                ret+="("+tree2str(root->left)+")";
                ret+="("+tree2str(root->right)+")";
            }else if(root->left!=NULL && root->right==NULL){
                ret+="("+tree2str(root->left)+")";
            
            }else if(root->left==NULL && root->right!=NULL){
                ret+="()";
                ret+="("+tree2str(root->right)+")";
            }else if(root->left==NULL && root->right==NULL){
                //Case 2: both not exist
                ret+= "";
            }

            return ret;

        }
        return "";
    }
    
    
};