class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        result = max(nums)
        cur_max, cur_min = nums[0], nums[0] 
        for i in range(1, len(nums)):
            if nums[i] == 0:
                cur_max, cur_min = 1, 1
                continue 
            tmp = cur_max 
            cur_max = max(nums[i], nums[i] * cur_max, nums[i] * cur_min)
            cur_min = min(nums[i], nums[i] * tmp, nums[i] * cur_min) 
            result = max(result, cur_max)
        return result



