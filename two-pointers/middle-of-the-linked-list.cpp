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
    ListNode* middleNode(ListNode* head) {
        int length = 0;
        int mid;
        ListNode* curNode = head;
        while(curNode!=NULL){
            length++;
            curNode = curNode->next;
        }
        mid = length/2;

        int begin=0;
        curNode = head;
        while(begin<mid){
            curNode = curNode->next;
            begin++;
        }

        return curNode;





    }
};