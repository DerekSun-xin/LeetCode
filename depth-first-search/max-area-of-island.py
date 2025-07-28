class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        max_area = 0
        row, col = len(grid), len(grid[0])
        q = collections.deque()
        visited = set()

        def bfs(r,c):
            area = 1
            q.append((r,c))
            visited.add((r,c))

            while len(q) != 0:
                r,c = q.popleft()
                directions = [[-1,0],[1,0],[0,-1],[0,1]]
                for dr, dc in directions:
                    nr = r + dr
                    nc = c + dc 
                    if (nr < row and nr >=0) and (nc < col and nc >=0) and grid[nr][nc] == 1 and (nr,nc) not in visited:
                        q.append((nr,nc))
                        visited.add((nr,nc))
                        area +=1
            return area


        for r in range(row):
            for c in range(col):
                if grid[r][c] ==  1 and (r,c) not in visited:
                    max_area = max(max_area, bfs(r,c))
        return max_area


