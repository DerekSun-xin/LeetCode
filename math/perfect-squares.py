class Solution:
    def numSquares(self, n: int) -> int:
        dp = [sys.maxsize]*(n+1)
        dp[0] = 0

        for i in range(1,n+1):
            sqrt = int(math.sqrt(i))
            store = dp[i]
            for j in range(sqrt,0,-1):
                square = j**2
                tmp = dp[i-square]+1
                if tmp<store:
                    store = tmp
            dp[i] = store
        
        return dp[n]
            
