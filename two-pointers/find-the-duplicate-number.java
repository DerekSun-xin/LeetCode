class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length; 
        for (int i = 0; i < n; i++){
            int cur = nums[i]; 
            for (int j = i + 1; j < n; j++){
                if (nums[j] == cur){
                    return cur;
                }
            }
        }
        return 0; 
    }
}