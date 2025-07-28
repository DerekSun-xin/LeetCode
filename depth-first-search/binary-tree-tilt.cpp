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
    int findTilt(TreeNode* root) {
        int sum = 0;
        help(root,sum);
        return sum;
    }
    
    void help(TreeNode* root, int& sum){
        if(root!=NULL){
            sum+=tilt(root);
            help(root->left,sum);
            help(root->right,sum);
        }
    }
    
    int tilt(TreeNode* root){
        return abs(nodeSum(root->left) - nodeSum(root->right));
    }
    
    int nodeSum(TreeNode* root){
       if(root==NULL){
           return 0;
       }
        return root->val+nodeSum(root->left)+nodeSum(root->right);
    
    }
};