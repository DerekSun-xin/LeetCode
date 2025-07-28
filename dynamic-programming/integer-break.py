class Solution:
    def integerBreak(self, n: int) -> int:
        if n==2:
            return 1
        if n==3:
            return 2
        dp = [0]*(n+1)
        dp[1] = 1
        dp[2] = 2
        if n>2:
            dp[3] = 3
            for i in range(4,n+1):
                tmp = 0
                for j in range(1,n//2+1):
                    rem = i-j
                    if tmp<dp[rem]*dp[j]:
                        tmp = dp[rem]*dp[j]
                dp[i]=tmp
        return dp[n]