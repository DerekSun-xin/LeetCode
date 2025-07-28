class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> answer = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return answer;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (First Row of current layer)
            for (int j = left; j <= right; j++) {
                answer.add(matrix[top][j]);
            }
            top++; // Move top boundary down

            // 2. Traverse Down (Last Column of current layer)
            for (int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            // 3. Traverse Left (Last Row of current layer)
            // IMPORTANT: Check if there's still a bottom row to traverse
            // (i.e., top hasn't crossed bottom)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    answer.add(matrix[bottom][j]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4. Traverse Up (First Column of current layer)
            // IMPORTANT: Check if there's still a left column to traverse
            // (i.e., left hasn't crossed right)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }

        return answer;
    }
}