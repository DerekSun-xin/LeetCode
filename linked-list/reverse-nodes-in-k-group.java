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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Handle edge case where head is null or k = 1
        if (head == null || k == 1){
            return head;
        }

        // Create a dummyHead
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // Initialize groupPrev
        ListNode groupPrev = dummyHead; 

        while (true){
            // Get the last node of the current group 
            ListNode kthNode = getKthNode(groupPrev, k); 
            if (kthNode == null){
                break; 
            }

            ListNode groupStart = groupPrev.next; // 1st node of current group 
            ListNode groupNext = kthNode.next; // 1st Node of next group
            
            // Reverse the current group
            kthNode.next = null; // Disconnect the current group and the rest of the list 
            ListNode reversedHead = reverseLinkedList(groupStart); 

            // Reconnect the reversed group
            groupPrev.next = reversedHead; // Link previous group to new head
            groupStart.next = groupNext; // Link next group to new tail 
            
            // Update the groupPrev to the new tail
            groupPrev = groupStart; 
        }

        return dummyHead.next; 
    }
    private ListNode getKthNode(ListNode head, int k){
        ListNode tmp = head;
        int count = 0;
        while(count < k && tmp != null){
            tmp = tmp.next;
            count++;  
        }
        return tmp;  
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp; 
        }
        return prev;
    }
}