class Solution {
    public int longestOnes(int[] nums, int k) {
        // There is no need to keep track of the length. We can just return right - left eventually. 
        int left = 0;
        int right;
        for ( right=0;right<nums.length;right++){
            // since right is always increasing, we only need to care about the case when nums[right]==0. Since we must include this 0 in our window, we can decrease the size of allowable 0s, which is k, by 1. 
            if (nums[right]==0){
                k--;
            }

            // If k is negative, then the current window is not allowed. we have to throw out 0 at front to make k return 0. If nums[left] is 0, then we add 1 to k since we throw out one 0. If nums[left] is 1, then we still have to throw it but k does not change. 
            if(k<0){
                k+= 1 - nums[left];
                left++;
            }
        }

        return right - left; 

    }
}