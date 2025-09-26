class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        int resultIndex = 0; 
        int[] res = new int[n-k+1]; 
        Deque<Integer> dq = new ArrayDeque<Integer>(); 
        for(int i = 0; i < n; i++){
            // Clean dq (front) 
            // Check if the first index of dq is out of bound
            if (!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.removeFirst(); 
            }
            // Clean dq (back)
            // Check if the back of dq is smaller than nums[i]
            // if nums[i] > back of dq, start popping until this condition is not true. 
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            // Add i to the back. 
            dq.add(i); 
            // If i >= k-1, add first element of dq to res
            if (i >= k-1){
                res[resultIndex] = nums[dq.peekFirst()]; 
                resultIndex++; 
            }
        }
        return res; 
    }
}