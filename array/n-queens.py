class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def create_board(state): 
            board = []
            for row in state: 
                board.append("".join(row)) 
            return board

        def dfs(row,cols,diagonals,anti_diagonals,state): 
            if row == n: 
                output.append(create_board(state))
                return 
            
            for col in range(n): 
                diagonal = row + col
                anti_diagonal = row - col
                if col in cols or diagonal in diagonals or anti_diagonal in anti_diagonals: 
                    continue 
                cols.add(col)
                diagonals.add(diagonal)
                anti_diagonals.add(anti_diagonal)
                state[row][col] = "Q"
                dfs(row + 1, cols, diagonals, anti_diagonals, state)
                state[row][col] = "." 
                cols.remove(col)
                diagonals.remove(diagonal)
                anti_diagonals.remove(anti_diagonal) 

        output = []
        empty_board = [["." for i in range(n)] for _ in range(n)]
        dfs(0,set(),set(),set(),empty_board)
        return output 
        
        
            


        