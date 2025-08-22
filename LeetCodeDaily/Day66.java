public class Day66 {
   public static void main(String[] args) {
     int[][] grid1 = {{0,1,0},{1,0,1}};
        System.out.println(minimumArea(grid1)); // Expected: 6
   } 

    public static int minimumArea(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        
        // Find top boundary
        int top = -1;
        for (int i = 0; i < m && top == -1; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    break;
                }
            }
        }
        
        // If no 1's found
        if (top == -1) return 0;
        
        // Find bottom boundary
        int bottom = -1;
        for (int i = m - 1; i >= 0 && bottom == -1; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bottom = i;
                    break;
                }
            }
        }
        
        // Find left boundary
        int left = -1;
        for (int j = 0; j < n && left == -1; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    left = j;
                    break;
                }
            }
        }
        
        // Find right boundary
        int right = -1;
        for (int j = n - 1; j >= 0 && right == -1; j--) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    right = j;
                    break;
                }
            }
        }
        
        return (bottom - top + 1) * (right - left + 1);
    }
}