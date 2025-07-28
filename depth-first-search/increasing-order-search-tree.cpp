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
    TreeNode* increasingBST(TreeNode* root) {
        vector<int> num;
        inorder_traversal(root, num);
        
        
        
        TreeNode* ret = new TreeNode(num[0]);
        TreeNode* pointer = ret;
        for(int i=1;i<num.size();i++){
            TreeNode* right = new TreeNode(num[i]);
            pointer->right = right;
            pointer = right;
        }
        return ret;
        

    }

   

    void inorder_traversal(TreeNode* root,vector<int>& num){
        if(root!=NULL){
            inorder_traversal(root->left,num);
            num.push_back(root->val);
            inorder_traversal(root->right,num);
        }
    }
};