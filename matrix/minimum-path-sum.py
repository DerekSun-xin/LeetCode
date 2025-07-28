class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        memo = dict()
        m = len(grid)
        n = len(grid[0])
        m-=1
        n-=1
        def findMin(m,n):
            if (m,n) in memo.keys():
                return memo[(m,n)]
            if m<0 or n<0:
                memo[(m,n)]=float('inf')
                return float('inf')
            if m==0 and n==0:
                memo[(m,n)]=grid[m][n]
                return grid[m][n]
        
            memo[(m,n)] = min(findMin(m-1,n),findMin(m,n-1))+grid[m][n]
            return memo[(m,n)]
        return findMin(m,n)
    