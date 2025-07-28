class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def bfs(r,c):
            visited = set()
            q = collections.deque()
            q.append((r,c)) 
            visited.add((r,c))
            # Check whether the grid is on the edge 
            sur = True
            directions = [[-1,0],[1,0],[0,1],[0,-1]]
            while q: 
                r,c = q.popleft()
                if r not in range(1,row-1) or c not in range(1, col-1): 
                    sur = False
                for dr, dc in directions: 
                    nr = r + dr
                    nc = c + dc 
                    if nr in range(row) and nc in range(col) and board[nr][nc] == "O" and (nr,nc) not in visited: 
                        q.append((nr,nc))
                        visited.add((nr,nc))
            # Turn grid in visited from "O" to "X" if sur is True
            for r,c in visited: 
                if sur == True: 
                    board[r][c] = "X"
                else:
                    unsur.add((r,c))
        row = len(board)
        col = len(board[0])
        unsur = set()
        for r in range(row):
            for c in range(col): 
                if board[r][c] == "O" and (r,c) not in unsur: 
                    bfs(r,c)
        


