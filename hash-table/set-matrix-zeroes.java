class Solution {
    public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
	boolean firstColZero = false, firstRowZero = false;
	// 1. 
	for (int i = 0; i < m; i++) {
		if (matrix[i][0] == 0) firstColZero = true;
}
for (int j = 0; j < n; j++) {
	if (matrix[0][j] == 0) firstRowZero = true;
}

// 2. Iterate matrix (except 1st col row)
for (int i = 1; i < m; i++) {
	for (int j = 1; j < n; j++) {
	if (matrix[i][j] == 0) {
		matrix[i][0] = 0;
		matrix[0][j] = 0;
	}
}
}

// set
for (int i = 1; i < m; i++) {
	for (int j = 1; j < n; j++) {
		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
			matrix[i][j] = 0;
}
}
}

// handle 1st col & row
if (firstColZero) {
	for (int i = 0; i < m; i++) {
		matrix[i][0] = 0;
	}
}

if (firstRowZero) {
	for (int j = 0; j < n; j++) {
		matrix[0][j] = 0;
	}
} 


    }
}