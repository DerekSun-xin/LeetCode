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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        ListNode* head = new ListNode(0);
        ListNode* cur = head;
        while(l1!=NULL || l2!=NULL || carry!=0){
            int x = 0;
            if(l1!=NULL){
                x =l1->val;
                l1=l1->next;
            }

            int y = 0;
            if(l2!=NULL){
                y = l2->val;
                l2=l2->next;
            }
            int sum = x+y+carry;
            carry = sum/10;
            int val = sum%10;
            ListNode* newNode = new ListNode(val);
            cur->next = newNode;
            cur = cur->next;

            
           
        }

        return head->next;
    }
};