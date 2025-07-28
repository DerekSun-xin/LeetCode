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
    vector<double> averageOfLevels(TreeNode* root) {
        vector<int> count;
        vector<double> sum;
        helper(root,0,count,sum);
        vector<double> ret;
        for(int i=0;i<count.size();i++){
            double val = sum[i]/count[i];
            ret.push_back(val);
        }
        return ret;
    }

    void helper(TreeNode* root,int depth, vector<int>& count, vector<double>& sum){
        if(root!=NULL){
            if(count.size()<=depth){
                count.push_back(1);
            }else{
                count[depth]++;
            }

            if(sum.size()<=depth){
                sum.push_back(root->val);
            }else{
                sum[depth]+=root->val;
            }   
           
            helper(root->left,depth+1,count,sum);
            helper(root->right,depth+1,count,sum);
        }
    }

};