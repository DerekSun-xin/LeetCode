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
    ListNode* swapPairs(ListNode* head) {

        if(head==NULL){
            return NULL;
        }

        return swap(head);
    }

    ListNode* swap(ListNode* head){
       if(head==NULL){
           return NULL;
       }

       ListNode* tmp;
       ListNode* headNext;
       if(head->next!=NULL){
       tmp = head->next->next;
       headNext = head->next;
       headNext->next = head;
       head->next = swap(tmp);
       }else{
           headNext = head;
       }
       
       return headNext;
    }
};