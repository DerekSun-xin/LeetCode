class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); 
        return kSum(nums, 0, 4, target); 
    }
    
    public List<List<Integer>> kSum(int[] nums, int start, int k, int target){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length; 
        if (start >= n){
            return result; 
        }else if(nums[start] * k > target){
            return result;
        }else if(nums[n-1]*k < target){
            return result; 
        }
        if (k == 2){
            return twoSum(nums,target,start); 
        }
        for(int i = start; i < n; i++){
            if (i>start && nums[i]==nums[i-1]){
                continue; 
            }
            List<List<Integer>> subList = kSum(nums, i+1, k-1, target - nums[i]); 
            for(List<Integer> tmp:subList){
                List<Integer> newList = new ArrayList<>(tmp); 
                newList.add(nums[i]); 
                result.add(newList); 
            }
        }
        return result; 
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>(); 
        int left = start;
        int right = nums.length-1; 
        while (left < right){
            int sum = nums[left] + nums[right]; 
            if (sum > target){
                right--;
            }else if (sum < target){
                left++;  
            }else{
                res.add(Arrays.asList(nums[left], nums[right]));
                right--;
                left++; 
                while(left < right && nums[right] == nums[right+1]){
                    right--; 
                }
                while(left < right && nums[left] == nums[left-1]){
                    left++; 
                }     
            }
        }
        return res; 
    }
}