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
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null; 
        }
        ListNode cur = head.next; // Use to traverse head
        ListNode reverse = new ListNode(head.val); // Use to store reversed LinkedList
        while(cur != null){
            ListNode prev = new ListNode(cur.val); 
            prev.next = reverse; 
            reverse = prev; 
            cur = cur.next; 
        }
        return reverse; 
    }
}