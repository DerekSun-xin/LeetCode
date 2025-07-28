class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        numList = []
        for i in range(row):
            for j in range(col):
                letter = matrix[i][j]
                numList.append(letter)
        
        left = 0
        right = len(numList)-1
        while left<=right:
            mid = (left+right)//2
            if numList[mid]==target:
                return True
            elif numList[mid]<target:
                left = mid+1
            else:
                right = mid-1
        
        return False