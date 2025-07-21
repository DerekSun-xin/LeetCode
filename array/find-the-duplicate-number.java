class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == nums[nums[i]-1]){
                if (i == nums[i]-1){
                    continue;
                }else{
                    return nums[i]; 
                }
            }
            while(nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp; 
            }
        }
        return -1; 
    }
}