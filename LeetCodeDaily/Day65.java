//Date: 21th August 2025
// Day: Thursday

public class Day65 {
    public static void main(String[] args) {
        
    }

}

 int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        
        // For each row, calculate heights of consecutive 1s ending at current row
        int[] heights = new int[n];
        
        for (int i = 0; i < m; i++) {
            // Update heights array for current row
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            
            // For each column as starting point, count submatrices
            for (int j = 0; j < n; j++) {
                int minHeight = heights[j];
                // Extend to the right and count submatrices
                for (int k = j; k < n && heights[k] > 0; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                    result += minHeight;
                }
            }
        }
        
        return result;