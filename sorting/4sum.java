class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n-3; i++){
            for (int j = i+1; j < n-2; j++){
                int left = j+1;
                int right = n-1;
                while(left < right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum > target){
                        right--;
                        while(right > 0 && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(sum < target){
                        left++;
                        while(left < n && nums[left]==nums[left-1]){
                            left++;
                        }
                    }else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        right--;
                        left++;
                        while(right > 0 && nums[right] == nums[right+1]){
                            right--;
                        }
                        while(left < n && nums[left]==nums[left-1]){
                            left++;
                        }
                    }
                }
            }
        }
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }
}