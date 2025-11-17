class KthLargest {
    private PriorityQueue<Integer> pq; 
    private int k; 

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k); 
        this.k = k; 
        for (int i = 0; i < nums.length; i++){
            pq.add(nums[i]); 
            if (pq.size() > k){
                pq.poll(); 
            }
        }
    }
    
    public int add(int val) {
        if (pq.isEmpty() || pq.size() < k){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.poll(); 
            pq.add(val);
        }
        
        return pq.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */