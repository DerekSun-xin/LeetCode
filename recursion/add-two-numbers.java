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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Handle l1
        ListNode cur1 = l1, cur2 = l2; 
        long digit = 1; 
        long sum = 0; 
        while(cur1 != null){
            sum += cur1.val * digit;
            digit *= 10; 
            cur1 = cur1.next; 
        }
        // Handle l2
        digit = 1; 
        while(cur2 != null){
            sum += cur2.val * digit;
            digit *= 10;  
            cur2 = cur2.next; 
        }
        if (sum == 0){
            return new ListNode(0); 
        }

        // Organize return
        ListNode dummy = new ListNode(); 
        ListNode cur = dummy; 
        while(sum != 0){
            int curDigit = (int)sum % 10; 
            sum /= 10; 
            ListNode curNode = new ListNode(curDigit); 
            cur.next = curNode; 
            cur = cur.next; 
        }
        return dummy.next; 
    }
}