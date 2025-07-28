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
    int closestValue(TreeNode* root, double target) {
        if(root==NULL) return 0;
        vector<int> list;
       // list.push_back(root->val);
        buildArray(root,list);
        sort(list.begin(),list.end());
        
        double diff = DBL_MAX;
        int res;
        for(int i=0;i<list.size();i++){
            if(abs(list[i]-target)<diff){
                diff = abs(list[i]-target);
                res = list[i];
            }
        }
        return res;
        
        
    }
    
    void buildArray(TreeNode* root, vector<int> &list){
        if(root == NULL) return ;
        list.push_back(root->val);
        buildArray(root->left,list);
        buildArray(root->right,list);
    }
    
    
    
    
};