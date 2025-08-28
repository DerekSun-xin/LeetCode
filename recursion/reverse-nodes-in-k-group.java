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
        // Turn the ListNode into a list
        List<Integer> ls = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            ls.add(tmp.val);
            tmp = tmp.next; 
        }
        // Handle edge case where list size <= k
        if (ls.size() <= k){
            return head; 
        }
        // Iterate the list to reverse the list k at a time
        for (int i = 1; i <= ls.size(); i++){
            if (i % k == 0){
                int left = i - k; 
                int right = i - 1; 
                swap(ls, left, right); 
            }
        }
        // Turn the reversed list into a ListNode and return
        ListNode dummyHead = new ListNode();
        tmp = dummyHead;
        for (int val :ls){
            ListNode cur = new ListNode(val);
            tmp.next = cur;
            tmp = tmp.next; 
        }
        return dummyHead.next;
    }

    private void swap(List<Integer> ls, int left, int right){
        int swapNum = (right - left) / 2 + 1; 
        while(left < right){
            int tmp = ls.get(left);
            ls.set(left, ls.get(right));
            ls.set(right, tmp); 
            left++;
            right--; 
        }
    }
}