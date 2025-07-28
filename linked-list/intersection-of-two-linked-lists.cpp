/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
       unordered_set<ListNode*> storage;
        while(headA){
            storage.insert(headA);
            headA=headA->next;
        }
        
        while(headB){
            if(storage.find(headB)!=storage.end()){
                return headB;
            }
            headB=headB->next;
        }
    
        return NULL;
    }
};