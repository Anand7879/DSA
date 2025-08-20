public class Day64 {
    public static void main(String[] args) {
        
    }

    public static int countSquares(int[][] matrix) {
          int m = matrix.length;
        int n = matrix[0].length;
        int totalSquares = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    // Update matrix[i][j] to store the side length of largest square
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) + 1;
                }
                totalSquares += matrix[i][j];
            }
        }
        
        return totalSquares;
    }
}
