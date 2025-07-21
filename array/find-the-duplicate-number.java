class Solution {
    public int findDuplicate(int[] nums) {
        // Condition: All positive number + number in range [1,n]
        for (int num: nums){
            int cur = Math.abs(num); 
            if (nums[cur] < 0){
                return Math.abs(num);
            }
            nums[cur] = -nums[cur]; 
        }
        return -1; 
    }
}