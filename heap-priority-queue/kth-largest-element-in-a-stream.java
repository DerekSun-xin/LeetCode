class KthLargest {
    private PriorityQueue<Integer> pq; 

    public KthLargest(int k, int[] nums) {
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray(); 

        this.pq = new PriorityQueue<>(k); 
        if (k < nums.length){
            for (int i = 0; i < k; i++){
                pq.add(nums[i]); 
            }
        }
    }
    
    public int add(int val) {
        if (pq.isEmpty()){
            pq.add(val); 
        }
        if (val > pq.peek()){
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