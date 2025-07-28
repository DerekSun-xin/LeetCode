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
    ListNode* reverseList(ListNode* head) {
        if(head==nullptr){
            return NULL;
        }
        ListNode* node = new ListNode(head->val);
        ListNode* cur = head->next;
        while(cur!=nullptr){
            ListNode* newNode = new ListNode(cur->val);
            newNode->next = node;
            node = newNode;
            cur=cur->next;
        }
        return node;
    }
};