//Date: 22th August 2025
// Day: Saturday

public class Day67 {
    private int[][] grid;
    private static final int INF = 1 << 30;
    
    public static void main(String[] args) {
        
    }
    
    public int minimumSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        int ans = m * n; // Initialize with maximum possible area
        
        // Case 1: Three horizontal sections (two horizontal cuts)
        for (int i1 = 0; i1 < m - 1; i1++) {
            for (int i2 = i1 + 1; i2 < m - 1; i2++) {
                ans = Math.min(ans,
                    f(0, 0, i1, n - 1) +           // Top section
                    f(i1 + 1, 0, i2, n - 1) +     // Middle section
                    f(i2 + 1, 0, m - 1, n - 1)    // Bottom section
                );
            }
        }
        
        // Case 2: Three vertical sections (two vertical cuts)
        for (int j1 = 0; j1 < n - 1; j1++) {
            for (int j2 = j1 + 1; j2 < n - 1; j2++) {
                ans = Math.min(ans,
                    f(0, 0, m - 1, j1) +           // Left section
                    f(0, j1 + 1, m - 1, j2) +     // Middle section
                    f(0, j2 + 1, m - 1, n - 1)    // Right section
                );
            }
        }
        
        // Case 3: Mixed cuts - various L-shaped and T-shaped divisions
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Configuration 1: Top-left, Top-right, Bottom
                ans = Math.min(ans,
                    f(0, 0, i, j) +                    // Top-left
                    f(0, j + 1, i, n - 1) +           // Top-right
                    f(i + 1, 0, m - 1, n - 1)         // Bottom
                );
                
                // Configuration 2: Top, Bottom-left, Bottom-right
                ans = Math.min(ans,
                    f(0, 0, i, n - 1) +               // Top
                    f(i + 1, 0, m - 1, j) +           // Bottom-left
                    f(i + 1, j + 1, m - 1, n - 1)     // Bottom-right
                );
                
                // Configuration 3: Left, Top-right, Bottom-right
                ans = Math.min(ans,
                    f(0, 0, m - 1, j) +               // Left
                    f(0, j + 1, i, n - 1) +           // Top-right
                    f(i + 1, j + 1, m - 1, n - 1)     // Bottom-right
                );
                
                // Configuration 4: Top-left, Bottom-left, Right
                ans = Math.min(ans,
                    f(0, 0, i, j) +                    // Top-left
                    f(i + 1, 0, m - 1, j) +           // Bottom-left
                    f(0, j + 1, m - 1, n - 1)         // Right
                );
            }
        }
        
        return ans;
    }
    
    // Helper function to calculate minimum rectangle area covering all 1s in subgrid
    private int f(int i1, int j1, int i2, int j2) {
        int minX = INF, minY = INF;
        int maxX = -INF, maxY = -INF;
        
        // Find bounding box of all 1s in the specified subgrid
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        // Return area of bounding rectangle (or 0 if no 1s found)
        return (minX == INF) ? 0 : (maxX - minX + 1) * (maxY - minY + 1);
    }
}
