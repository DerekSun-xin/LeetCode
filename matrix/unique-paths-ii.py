class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        m-=1
        n-=1
        memo = dict()
        def uniquePaths(m,n):
            if (m,n) in memo.keys():
                return memo[(m,n)]
            if m<0 or n<0:
                memo[(m,n)] = 0
                return 0
            if obstacleGrid[m][n] == 1:
                memo[(m,n)] = 0
                return 0 
            if m==0 and n==0:
                memo[(m,n)] = 1
                return 1
            memo[(m,n)]= uniquePaths(m-1,n)+uniquePaths(m,n-1)
            return memo[(m,n)]
        return uniquePaths(m,n)