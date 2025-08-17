//Date: 17th August 2025
// Day: Sunday

public class Day61 {
    public static void main(String[] args) {
        
    }

    public static double new21Game(int n, int k, int maxPts) {
         if (k == 0) return 1.0;
        if (k - 1 + maxPts <= n) return 1.0;
        
        double[] dp = new double[k + maxPts];
        
        // Base case: for points >= k, probability is 1 if <= n, else 0
        for (int i = k; i <= Math.min(n, k + maxPts - 1); i++) {
            dp[i] = 1.0;
        }
        
        // Use sliding window to optimize calculation
        double windowSum = Math.min(n - k + 1, maxPts);
        
        // Fill dp table from k-1 down to 0
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = windowSum / maxPts;
            
            // Update sliding window for next iteration
            windowSum = windowSum - dp[i + maxPts] + dp[i];
        }
        
        return dp[0];
    }
}