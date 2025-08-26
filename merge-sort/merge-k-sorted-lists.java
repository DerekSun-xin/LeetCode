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
        // 1. Gather all elements into a single list ret
        List<Integer> allValues = new ArrayList<>(); 
        for (ListNode node: lists){
            ListNode head = node;
            while (head != null){
                allValues.add(head.val);
                head = head.next; 
            }
        }
        if (allValues.isEmpty()){
            return null; 
        }
        int size = allValues.size();
        int[] retArr = new int[size];
        for(int i = 0; i < size; i++) {
            retArr[i] = allValues.get(i);
        }

        // 2. Sort ret using mergesort
        mergeSort(retArr, 0, size - 1);

        // 3. Convert the ret back to a ListNode and return
        ListNode dummyHead = new ListNode();
        ListNode tmp = dummyHead;  
        for (Integer val: retArr){
            ListNode cur = new ListNode(val); 
            tmp.next = cur;
            tmp = tmp.next; 
        } 
        return dummyHead.next; 
    }

    private void mergeSort(int[] arr, int left, int right){
        if (left < right){
            // Calculate the middle of the arr
            int middle = left + (right - left) / 2;
            // Sort the two halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            // Merge the sorted two halves
            merge(arr, left, middle, right); 
        }
    }

    private void merge(int[] arr, int left, int middle, int right){
        // Find the size of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle; 

        int[] L = new int[n1];
        int[] R = new int[n2]; 

        for (int i = 0; i < n1; i++){
            L[i] = arr[left + i]; 
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[middle + 1 + j]; 
        }

        // Sort L and R and merge them into arr[left:right+1] in asending order
        int i = 0, j = 0; 
        int k = left; 
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++; 
            }
            k++; 
        }
        
        // Copy remaining elements into arr
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++; 
        }

        while(j<n2){
            arr[k] = R[j];
            j++;
            k++; 
        }
    }
}