class Solution:
    def numWays(self, n: int, k: int) -> int:
        dp = [0]*(n+1)
        if n>=1:
            dp[1] = k
        if n>=2:
            dp[2] = k**2
        if n>=3:
            for i in range(3,n+1):
                dp[i] = (k-1)*(dp[i-1]+dp[i-2])
        return dp[n]