class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = nums.length - 1; 
        while (left < right){
            int sum = left + right; 
            if (sum > target){
                right--;
            }else if(sum < target){
                left++; 
            }else{
                return [left,right]; 
            }
        }
    }
}