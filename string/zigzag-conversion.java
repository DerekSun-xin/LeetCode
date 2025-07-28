class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s; 
        }

        int n = s.length(); 
        int sections = (int) Math.ceil((double) n / (2*numRows - 2)); 
        int numCols = sections * (numRows - 1); 
        
        char[][] matrix = new char[numRows][numCols]; 
        int currRow = 0, currCol = 0; 
        int currStringIndex = 0; 

        // Iterate in Zig-Zag pattern on matrix and fill it with string characters. 
        while(currStringIndex < n){
            // Move down 
            while(currRow < numRows && currStringIndex < n){
                matrix[currRow][currCol] = s.charAt(currStringIndex); 
                currRow++;
                currStringIndex++; 
            }

            // Move up a row and move right a column 
            currRow-=2; 
            currCol++;
            while(currRow > 0 && currCol < numCols && currStringIndex < n){
                matrix[currRow][currCol] = s.charAt(currStringIndex); 
                currStringIndex++;
                currRow--; 
                currCol++; 
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (char[] row: matrix){
            for (char character: row){
                if (character != '\u0000'){
                    answer.append(character); 
                }
            }
        }
        return answer.toString(); 
    }
}