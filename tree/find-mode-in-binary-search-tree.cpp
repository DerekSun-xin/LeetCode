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
    vector<int> findMode(TreeNode* root) {
        unordered_map<int,int> map1;
        vector<int> res;
        helper(root, map1);
        int max = 0;
        for(auto x:map1){
            if(x.second>max){
                max = x.second;
            }
        }
        
        for(auto x:map1){
            if(x.second ==max){
                res.push_back(x.first);
            }
        }
        return res;
        
    }
    
    void helper(TreeNode* root, unordered_map<int,int> &map1){
        if(root!=NULL){
            if(map1.find(root->val)!=map1.end()){
                map1[root->val]++;
            }else{
                map1[root->val]=1;
            }
            helper(root->left,map1);
            helper(root->right,map1);
        }
    }
};