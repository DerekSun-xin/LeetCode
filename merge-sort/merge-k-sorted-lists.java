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
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge case where the lists is null or empty
        if (lists == null || lists.length == 0){
            return null; 
        }
        // Initialize the minHeap 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        // Populate the minHeap with head nodes from lists.
         for (ListNode head: lists){
            if (head != null){
                minHeap.add(head); 
            }
        }
        // Build the result ListNode
        ListNode dummyHead = new ListNode(); 
        ListNode tmp = dummyHead; 
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll(); 
            ListNode newNode = new ListNode(node.val); 
            tmp.next = newNode;
            tmp = tmp.next;

            if(node.next != null){
                minHeap.add(node.next); 
            }
        }
        // Return the result ListNode
        return dummyHead.next; 
    }
}