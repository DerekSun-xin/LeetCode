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
        // Min-Heap 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val); 
        ListNode dummy = new ListNode();
        ListNode cur = dummy; 
        for(ListNode curNode: lists){
            if (curNode != null){
                pq.add(curNode);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = cur.next; 
            if (minNode.next != null){
                pq.add(minNode.next); 
            }
        }

        return dummy.next;
    }
}