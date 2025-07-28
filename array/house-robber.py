class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 1:
            return nums[0]
        dp = [0 for i in range(length)]
        dp[0] = nums[0]
        dp[1] = max(dp[0],nums[1])
        for i in range(2,length):
            dp[i] = max(dp[i-2]+nums[i],dp[i-1])
        return max(dp[length-1],dp[length-2])
