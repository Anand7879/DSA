//Date: 8th August 2025
// Day: Friday

public class Day52 {
    public static void main(String[] args) {
        
    }
    private static Double[][] memo;
    
    public static double soupServings(int n) {
        // Optimization: For large n, the probability approaches 1
        // This is because soup A is served more frequently than soup B
        if (n >= 4800) return 1.0;
        
        // Convert to units of 25ml to reduce state space
        // Since all operations are multiples of 25
        int units = (n + 24) / 25; // Ceiling division
        memo = new Double[units + 1][units + 1];
        
        return solve(units, units);
    }
    
    private static double solve(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5; // Both empty at same time
        if (a <= 0) return 1.0;           // A empty first
        if (b <= 0) return 0.0;           // B empty first
        
        // Check memoization
        if (memo[a][b] != null) {
            return memo[a][b];
        }
        
        // Calculate probability based on 4 possible operations
        // Each operation has probability 0.25
        double result = 0.25 * (
            solve(Math.max(0, a - 4), b) +        // Serve 100ml A, 0ml B
            solve(Math.max(0, a - 3), Math.max(0, b - 1)) + // Serve 75ml A, 25ml B
            solve(Math.max(0, a - 2), Math.max(0, b - 2)) + // Serve 50ml A, 50ml B
            solve(Math.max(0, a - 1), Math.max(0, b - 3))   // Serve 25ml A, 75ml B
        );
        
        memo[a][b] = result;
        return result;
    }
}
