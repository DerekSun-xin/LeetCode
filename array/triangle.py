class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        @lru_cache
        def backtracking(row,col):
            if row == len(triangle)-1:
                return triangle[row][col]
            
            return triangle[row][col]+min(backtracking(row+1,col),backtracking(row+1,col+1))
        return backtracking(0,0)
        
                