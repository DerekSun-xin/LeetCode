class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        boardSize = 9
        row = [set() for i in range(boardSize)]
        col = [set() for i in range(boardSize)]
        box = [set() for i in range(boardSize)]
        for i in range(9):
            for j in range(9):
                '''check row: row[i]represents ith row '''
                val = board[i][j]
                if val == ".":
                    continue
                if val in row[i]:
                    print("Row:False")
                    return False   
                else:
                    row[i].add(val)
                
                '''check column: col[i] represents ith column'''
                if val in col[j]:
                    print("Col:False")
                    return False
                else:
                    col[j].add(val)
                
                '''check box'''
                boxNum = (i//3)*3+j//3
                '''box[boxNum]represents the box that val belongs to'''
                if val in box[boxNum]:
                    print("Box:false")
                    return False
                else:
                    box[boxNum].add(val)
        

        return True

                
        
        

