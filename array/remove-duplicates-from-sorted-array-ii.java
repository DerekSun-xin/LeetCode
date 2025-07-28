class Solution {
    public int removeDuplicates(int[] nums) {
        // j: the index that need to be replaced
        int j=1,count = 1;

        for(int i=1;i<nums.length;i++){
            if (nums[i] == nums[i-1]){
                count++;
            }else{
                count = 1;
            }

            // Only when count<=2, we do the replacement and increase j. Hence we can ignore the extra element and hold j when count>2. 
            if (count<=2){
                nums[j] = nums[i];
                j++; 
            }    
        }
        return j;
        
    }
}