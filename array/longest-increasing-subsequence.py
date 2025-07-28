class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp[i]: the length of the longest increasing subsequence that ends with the ith element
        # dp[i] = max(dp[i], dp[j] + 1) for all j where nums[j] < nums[i] and j < i 
        dp = [1 for _ in range(len(nums))]

        for i in range(1,len(nums)):
            for j in range(0,i): 
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j] + 1)
        return max(dp)