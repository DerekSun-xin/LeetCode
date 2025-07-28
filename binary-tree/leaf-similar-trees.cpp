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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> leaf1;
        vector<int> leaf2;
        findLeaf(root1,leaf1);
        findLeaf(root2,leaf2);

        if(leaf1.size()!=leaf2.size()){
            return false;
        }else{
            for(int i=0;i<leaf1.size();i++){
                if(leaf1[i]!=leaf2[i]){
                    return false;
                }
            }
        }

        return true;
    }

    void findLeaf(TreeNode* root,vector<int>& leaf){
        if(root!=NULL){
            if(root->left==NULL && root->right==NULL){
                leaf.push_back(root->val);
            }
            findLeaf(root->left,leaf);
            findLeaf(root->right,leaf);
        }
    }
};