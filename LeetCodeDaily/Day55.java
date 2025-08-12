//Date: 11th August 2025
// Day: Monday
import java.util.*;
public class Day55 {
    
    public static void main(String[] args) {
        int n = 15;
        int [][] queries = {{0,1},{2,2},{0,3}};
    }

     private static final int MOD = 1_000_000_007;
    
    public static int[] productQueries(int n, int[][] queries) {
        // Extract exponents of powers of 2
        List<Integer> exponents = new ArrayList<>();
        int bit = 0;
        
        while (n > 0) {
            if ((n & 1) == 1) {
                exponents.add(bit);
            }
            n >>= 1;
            bit++;
        }
        
        // Build prefix sum array for exponents
        int[] prefixSum = new int[exponents.size() + 1];
        for (int i = 0; i < exponents.size(); i++) {
            prefixSum[i + 1] = prefixSum[i] + exponents.get(i);
        }
        
        // Process queries
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            // Sum of exponents in range [left, right]
            int expSum = prefixSum[right + 1] - prefixSum[left];
            
            // Calculate 2^expSum mod MOD using fast exponentiation
            result[i] = (int) fastPower(2, expSum, MOD);
        }
        
        return result;
    }
    
    private static long fastPower(long base, int exp, int mod) {
        long result = 1;
        base %= mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        
        return result;
    }
}

// Simple bit manipulation approach
class SolutionSimple {
    private static final int MOD = 1_000_000_007;
    
    public int[] productQueries(int n, int[][] queries) {
        // Extract powers of 2 from n
        List<Integer> powers = new ArrayList<>();
        
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }
        
        int[] result = new int[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            long product = 1;
            for (int i = queries[q][0]; i <= queries[q][1]; i++) {
                product = (product * powers.get(i)) % MOD;
            }
            result[q] = (int) product;
        }
        
        return result;
    }
}
