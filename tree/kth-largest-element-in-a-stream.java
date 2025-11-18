class KthLargest {
    // Use min-heap to store k elements all the time. The smallest element is the kth largest element in the heap. 
    private PriorityQueue<Integer> pq; 
    private int k; 

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k; 

        // Add k elements into the pq
        for (int i = 0; i < nums.length; i++){
            pq.add(nums[i]); 
            if (pq.size() > k){
                pq.poll(); 
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k){
            pq.poll();
        }
        return pq.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */