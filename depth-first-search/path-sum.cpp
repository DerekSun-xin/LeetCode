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
    bool hasPathSum(TreeNode* root, int targetSum) {
        int sum = 0;
        if(root==NULL){
            return false;
        }
        return helper(root,targetSum,sum);
    }
    
    bool helper(TreeNode* root, int targetSum,int sum){
       if(root!=NULL){
           sum = sum+root->val;
           if(root->left!=NULL && root->right==NULL){
               return (helper(root->left,targetSum,sum));
           }else if(root->left==NULL && root->right!=NULL){
               return helper(root->right,targetSum,sum);
           }else{
                return  (helper(root->left,targetSum,sum) || helper(root->right,targetSum,sum));
           }
           
           
       }else{
           cout<<sum<<endl;
           if(sum==targetSum){
               
               return true;
           }else{
               return false;
           }
           
       }
        
    }
};