class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0 
        
        row , col = len(grid), len(grid[0])
        visited = set()
        q = collections.deque()
        num = 0

        def bfs(r,c):
            q.append((r,c))
            visited.add((r,c))
            while len(q) != 0:  
                r,c = q.popleft()        
                directions = [[-1,0],[1,0],[0,1],[0,-1]]
                for dr, dc in directions:
                    nr = r + dr
                    nc = c + dc
                    if (nr < row and nr >= 0) and (nc < col and nc >= 0) and (grid[nr][nc] == "1") and ((nr,nc) not in visited):
                        q.append((nr,nc)) 
                        visited.add((nr,nc))
            
                    
        for r in range(row):
            for c in range(col):
                if (r,c) not in visited and grid[r][c] == "1":
                    bfs(r,c)
                    num+=1

        return num