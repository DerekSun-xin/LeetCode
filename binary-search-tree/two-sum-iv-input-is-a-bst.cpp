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
    bool findTarget(TreeNode* root, int k) {
        vector<int> visited;
        return helper(root,k,visited);
    }

    bool helper(TreeNode* root, int k, vector<int>& visited){
        if(root!=NULL){
            int rest = k - root->val;
            auto it = find(visited.begin(),visited.end(),rest);
            if(it!=visited.end()){
                return true;
            }else{
                visited.push_back(root->val);
                return helper(root->left,k,visited) || helper(root->right,k,visited);
            }
        }
        return false;
    }
};