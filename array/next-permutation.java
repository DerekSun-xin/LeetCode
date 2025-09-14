class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length; 
        int i;         
        //1. Find the break point.
        for (i = n-2; i >=0; i--){
            if (nums[i] < nums[i+1]){
                break; 
            }
        }

        //2. if br does not exist
        if (i == -1){
            reverse(nums, 0, n-1); 
            return; 
        }

        //3. if br exists. 
        //3.1 Find the idx of the smallest number in the right half of BR and is greater than br. 
        //3.2 Swap them. 
        int rightHalfMinIdx = findRightHalfMinIdx(nums, i+1, n-1, nums[i]);
        int tmp = nums[rightHalfMinIdx]; 
        nums[rightHalfMinIdx] = nums[i];
        nums[i] = tmp; 
        
        //4. Reverse the entire right half of BR (i+1, n-1) and return the result. 
        reverse(nums, i+1, n-1); 
    }

    public void reverse(int[] nums, int left, int right){
        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;

        }
    }

    public int findRightHalfMinIdx(int[] nums, int left, int right, int br){
        int smallestIdx = right; 
        for(int i = right-1; i >=left; i--){
            if (nums[i] < nums[smallestIdx] && nums[i] > br){
                smallestIdx = i;
            }
        }
        return smallestIdx; 
    }
}