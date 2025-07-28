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
    int findSecondMinimumValue(TreeNode* root) {
        vector<int> val;
        helper(root,val);
        for(int i=0;i<val.size();i++){
            cout<<val[i]<<endl;
        }
        if(val.size()<=1){
            return -1;
        }else{
            sort(val.begin(),val.end());
            return val[1];
        }
        
        

    }

    void helper(TreeNode* root, vector<int>& val){
        if(root!=NULL){
            auto it = find(val.begin(),val.end(),root->val);
            if(it==val.end()){
                val.push_back(root->val);
            }
            helper(root->left,val);
            helper(root->right,val);
        }
    }
};