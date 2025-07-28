class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        fresh, time = 0, 0 
        rotten = collections.deque()
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    fresh += 1
                elif grid[r][c] == 2:
                    rotten.append((r,c))
        
        directions = [[-1,0], [1,0], [0,1],[0,-1]]
        while fresh > 0 and len(rotten) != 0:
            # BFS with multiple source 
            length = len(rotten)
            for _ in range(length):
                r,c = rotten.popleft()
                for dr, dc in directions:
                    nr = r + dr
                    nc = c + dc
                    if nr in range(rows) and nc in range(cols) and grid[nr][nc] == 1:
                        grid[nr][nc] = 2 
                        fresh -= 1 
                        rotten.append((nr,nc)) 
            time += 1 
        return time if fresh == 0 else -1 
