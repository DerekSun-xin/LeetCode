class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1; 
        for (int num: nums){
            int cur = Math.abs(num);
            if (nums[cur] < 0){
                duplicate = cur; 
                break;
            }
            nums[cur] = -nums[cur]; 
        }
        for (int i = 0; i< nums.length; i++){
            nums[i] = Math.abs(nums[i]); 
        }
        return duplicate; 
    }
}