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
    
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        construct_path(root,"",res);
        return res;
    }
    
    void construct_path(TreeNode* root,string path,vector<string> &res){
        if(root!=NULL){
           path += to_string(root->val);
            if(root->left==NULL && root->right==NULL){
                //reaching a leaf
                res.push_back(path);
            }else{
                path+="->";
                construct_path(root->left,path,res);
                construct_path(root->right,path,res);
            } 
        } 
            
    }
       
    
    

    
    
};