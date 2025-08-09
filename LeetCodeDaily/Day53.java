//Date: 9th August 2025
// Day: Saturday

public class Day53 {
    public static void main(String[] args) {
        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 8, 16, 17, 32, -16, 0};
        
        for (int n : testCases) {
            System.out.println("n = " + n + " -> " + isPowerOfTwo(n));
        }
    }   
    // Method 1: Bit Manipulation (Most Optimal)
    // Time: O(1), Space: O(1)
    public static boolean isPowerOfTwo(int n) {
        // A power of 2 has exactly one bit set
        // n & (n-1) removes the rightmost set bit
        // For powers of 2, this results in 0
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    // Method 2: Alternative bit manipulation
    // Time: O(1), Space: O(1)
    public boolean isPowerOfTwoAlt1(int n) {
        // Powers of 2: 1, 2, 4, 8, 16, 32...
        // In binary: 1, 10, 100, 1000, 10000, 100000...
        // n & -n isolates the rightmost set bit
        // For powers of 2, this equals n itself
        return n > 0 && (n & -n) == n;
    }
    
    // Method 3: Using built-in function
    // Time: O(1), Space: O(1)
    public boolean isPowerOfTwoAlt2(int n) {
        // Integer.bitCount() returns number of 1-bits
        // Powers of 2 have exactly one 1-bit
        return n > 0 && Integer.bitCount(n) == 1;
    }
    
    // Method 4: Mathematical approach (less optimal due to floating point)
    // Time: O(1), Space: O(1)
    public boolean isPowerOfTwoMath(int n) {
        if (n <= 0) return false;
        double log = Math.log(n) / Math.log(2);
        return log == (int) log;
    }
    
    // Method 5: Iterative division (least optimal)
    // Time: O(log n), Space: O(1)
    public boolean isPowerOfTwoIterative(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
} 
