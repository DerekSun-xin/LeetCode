class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        def dfs(index, i, j):
            if index == len(word): 
                return True 
            directions = [[-1,0],[1,0],[0,-1],[0,1]]
            for dr,dc in directions: 
                nr = i + dr 
                nc = j + dc 
                if nr in range(rows) and nc in range(cols) and (nr,nc) not in visited and board[nr][nc] == word[index]: 
                    visited.add((nr,nc)) 
                    if dfs(index + 1, nr, nc):
                        return True
                    visited.remove((nr,nc))
            return False 
        
 
        for i in range(rows):
            for j in range(cols): 
                if board[i][j] == word[0]:
                    visited = set()
                    visited.add((i,j))
                    if dfs(1,i,j):
                        return True
        return False 

       




     
