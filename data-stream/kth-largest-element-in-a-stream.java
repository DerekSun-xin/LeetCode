class KthLargest {
    private PriorityQueue<Integer> pq; 

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums); 
        this.pq = new PriorityQueue<>(k); 
        for (int i = nums.length-1; i > nums.length-1-k; i--){
            pq.add(nums[i]); 
        }
    }
    
    public int add(int val) {
        if (val > pq.peek()){
            pq.poll(); 
            pq.add(val);
            return pq.peek(); 
        }else{
            return pq.peek(); 
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */