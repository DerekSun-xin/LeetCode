class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        def dfs(row,col,reachable): 
            reachable.add((row,col))
            stack = [(row,col)]
            while len(stack) != 0: 
                r,c = stack.pop()
                directions = [[-1,0],[1,0],[0,1],[0,-1]]
                for dr, dc in directions: 
                    nr = r + dr 
                    nc = c + dc 
                    if nr in range(num_rows) and nc in range(num_cols) and (nr,nc) not in reachable and heights[nr][nc] >= heights[r][c]: 
                        reachable.add((nr,nc))
                        stack.append((nr,nc))
        if not heights or not heights[0]:
            return []
        
        num_rows, num_cols = len(heights), len(heights[0])
        pacific_reachable = set()
        atlantic_reachable = set() 

        for i in range(num_rows):
            dfs(i, 0, pacific_reachable)
            dfs(i, num_cols-1, atlantic_reachable)
        for j in range(num_cols): 
            dfs(0,j, pacific_reachable)
            dfs(num_rows-1,j,atlantic_reachable) 
        

        
        return  list(pacific_reachable & atlantic_reachable)





        
        