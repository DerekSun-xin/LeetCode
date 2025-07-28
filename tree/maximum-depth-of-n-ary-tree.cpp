/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    
    int maxDepth(Node* root) {
       if(root==NULL){
           return 0;
       }else if(root->children.size()==0){
           return 1;
       }else{
           vector<int> storage;
           for(int i=0;i<root->children.size();i++){
               storage.push_back(maxDepth(root->children[i]));
           }
           return *max_element(storage.begin(),storage.end())+1;
       }
    }

};