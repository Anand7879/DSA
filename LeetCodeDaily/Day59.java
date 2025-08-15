public class Day59 {
     public boolean isPowerOfFourModulo(int n) {
        // A positive integer is a power of 4 if and only if:
        // 1. It's a power of 2
        // 2. When divided by 3, remainder is 1
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
    
    // Test method
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        int[] testCases = {1, 2, 4, 8, 16, 64, 256, 1024, 5, 0, -1};
        
        System.out.println("Testing isPowerOfFour methods:");
        System.out.println("n\tMath\tBitwise\tIterative\tModulo");
        
        for (int n : testCases) {
            boolean math = sol.isPowerOfFour(n);
            boolean bitwise = sol.isPowerOfFourBitwise(n);
            boolean iterative = sol.isPowerOfFourIterative(n);
            boolean modulo = sol.isPowerOfFourModulo(n);
            
            System.out.printf("%d\t%b\t%b\t%b\t\t%b%n", n, math, bitwise, iterative, modulo);
        }
    }
}
