//Date: 15th August 2025
// Day: Friday
public class Day59 {
    
    // Test method
    public static void main(String[] args) {
        // Test cases
        int[] testCases = {1, 2, 4, 8, 16, 64, 256, 1024, 5, 0, -1};
        
        for (int n : testCases) {
            boolean modulo = isPowerOfFourModulo(n);
            
            System.out.printf("%b%n", n,modulo);
        }
    }
    public static boolean isPowerOfFourModulo(int n) {
       // A positive integer is a power of 4 if and only if:
       // 1. It's a power of 2
       // 2. When divided by 3, remainder is 1
       return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
   }
}
