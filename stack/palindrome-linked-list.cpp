/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        vector<int> vec;
        while(head!=NULL){
            vec.push_back(head->val);
            head=head->next;
        }
        string a;
        string b;
        for(int i=0;i<vec.size();i++){
            a.append(to_string(vec[i]));
        }
        
        for(int j=vec.size()-1;j>=0;j--){
            b.append(to_string(vec[j]));
        }
        
        if(a==b){
            return true;
        }else{
            return false;
        }
        
    }
};