//Date 17th july 2025
// Day Thursday

public class Day30 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        System.out.println(maximumLength(nums, k));
    }

    public static int maximumLength(int[] nums, int k) {
        int maxLength = 0;
        
        // Try all possible values of (a + b) % k
        for (int val = 0; val < k; val++) {
            // dp[r] stores the maximum length of valid subsequence ending with element having residue r
            int[] dp = new int[k];
            
            // Process each element in the array
            for (int num : nums) {
                int r = num % k;  // Current element's residue
                int s = (k + val - r) % k;  // Required previous element's residue
                
                // Current element can either start a new subsequence (length 1)
                // or extend an existing subsequence ending with residue s
                int candidateLength = Math.max(1, dp[s] + 1);
                
                // Update dp[r] if we found a longer subsequence
                dp[r] = Math.max(dp[r], candidateLength);
                
                // Update the global maximum
                maxLength = Math.max(maxLength, dp[r]);
            }
        }
        
        return maxLength;
    }
}