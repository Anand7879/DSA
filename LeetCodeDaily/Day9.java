// Date 26th june 2025
// Day thursday

// You are given a binary string s and a positive integer k.
// Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
// Note:
// The subsequence can contain leading zeroes.
// The empty string is considered to be equal to 0.
// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 


public class Day9 {

    public static void main(String[] args) {

        String str = "1001010";
        int k = 5;

        System.out.println(longestSubsequence(str, k));
        
    }
    
    public static int longestSubsequence(String s, int k) {
        int count = 0;       // Final result
        long val = 0;        // Current value of subsequence
        int pow = 0;         // Bit position (0 for LSB)

        // Step 1: Include all '0's (they don't increase value)
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '0') {
                count++;
                pow++;
            } else {
                // Try to include this '1' if value stays ≤ k
                if (pow < 32) {
                    long add = 1L << pow;
                    if (val + add <= k) {
                        val += add;
                        count++;
                        pow++;
                    } else {
                        // Cannot include this '1' without exceeding k
                        // But we still need to increment pow to shift left
                        pow++;
                    }
                }
            }
        }

        return count;
    }
}
