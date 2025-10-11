/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1; 
        }
        
        ListNode cur1 = list1; // Iterate list1
        ListNode cur2 = list2; // Iterate list2 
        ListNode dummyHead = new ListNode(); 
        ListNode tmp = dummyHead; 
        while(cur1 != null){
            if (cur2 == null){
                break; 
            }
            ListNode cur; 
            if (cur1.val <= cur2.val){
                cur = new ListNode(cur1.val); 
                cur1 = cur1.next;
            }else{
                cur = new ListNode(cur2.val); 
                cur2 = cur2.next; 
            }
            tmp.next = cur;
            tmp = tmp.next; 
        }

        while (cur1 != null){
            ListNode cur = new ListNode(cur1.val); 
            tmp.next = cur;
            tmp = tmp.next;  
            cur1 = cur1.next; 
        }
        while (cur2 != null){
            ListNode cur = new ListNode(cur2.val);
            tmp.next = cur;
            tmp = tmp.next; 
            cur2 = cur2.next; 
        }
        return dummyHead.next; 
    } 
}