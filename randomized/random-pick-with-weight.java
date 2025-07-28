class Solution {
    // I use Binary Search Here. The condition is a sorted list ASC. 
    private int[] prefixSum;
    private int length; 
    private int totalSum; 

    public Solution(int[] w) {
        this.length = w.length;
        this.prefixSum = new int[this.length];
        int totalSum = 0;
        for(int i=0;i<this.length;i++){
            totalSum+=w[i];
            this.prefixSum[i] = totalSum;
        }
        this.totalSum = totalSum;
    }
    
    public int pickIndex() {
        int low = 0, high = this.length;
        double target = Math.random() * this.totalSum; 
        while (low<high){
            int mid = low + (high-low)/2;
            if (target>this.prefixSum[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */