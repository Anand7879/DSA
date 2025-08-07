//Date: 7th August 2025
// Day: Thursday

public class Day51 {
    public static void main(String[] args) {
        int[][] fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        System.out.println(maxCollectedFruits(fruits));
    }

    public static int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        
        // Calculate fruits collected by child starting from (0,0)
        // This child can only move diagonally to reach (n-1, n-1)
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += fruits[i][i];
        }
        
        // DP for child starting from (0, n-1) - upper triangle
        int[][] dpUpper = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpUpper[i][j] = -1;
            }
        }
        dpUpper[0][n-1] = fruits[0][n-1];
        
        // Fill DP table for upper triangle child
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (dpUpper[i][j] == -1) continue;
                
                // Move to (i+1, j-1), (i+1, j), (i+1, j+1)
                if (i+1 < n && j-1 >= 0 && j-1 > i+1) {
                    dpUpper[i+1][j-1] = Math.max(dpUpper[i+1][j-1], 
                                               dpUpper[i][j] + fruits[i+1][j-1]);
                }
                if (i+1 < n && j > i+1) {
                    dpUpper[i+1][j] = Math.max(dpUpper[i+1][j], 
                                             dpUpper[i][j] + fruits[i+1][j]);
                }
                if (i+1 < n && j+1 < n && j+1 > i+1) {
                    dpUpper[i+1][j+1] = Math.max(dpUpper[i+1][j+1], 
                                                dpUpper[i][j] + fruits[i+1][j+1]);
                }
            }
        }
        
        // DP for child starting from (n-1, 0) - lower triangle
        int[][] dpLower = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpLower[i][j] = -1;
            }
        }
        dpLower[n-1][0] = fruits[n-1][0];
        
        // Fill DP table for lower triangle child
        for (int j = 0; j < n-1; j++) {
            for (int i = j+1; i < n; i++) {
                if (dpLower[i][j] == -1) continue;
                
                // Move to (i-1, j+1), (i, j+1), (i+1, j+1)
                if (i-1 >= 0 && j+1 < n && i-1 > j+1) {
                    dpLower[i-1][j+1] = Math.max(dpLower[i-1][j+1], 
                                                dpLower[i][j] + fruits[i-1][j+1]);
                }
                if (j+1 < n && i > j+1) {
                    dpLower[i][j+1] = Math.max(dpLower[i][j+1], 
                                             dpLower[i][j] + fruits[i][j+1]);
                }
                if (i+1 < n && j+1 < n && i+1 > j+1) {
                    dpLower[i+1][j+1] = Math.max(dpLower[i+1][j+1], 
                                                dpLower[i][j] + fruits[i+1][j+1]);
                }
            }
        }
        
        // Find maximum fruits collected by both children when reaching near (n-1, n-1)
        int upperMax = dpUpper[n-2][n-1];
        int lowerMax = dpLower[n-1][n-2];
        
        return diagonalSum + upperMax + lowerMax;
    }
}
