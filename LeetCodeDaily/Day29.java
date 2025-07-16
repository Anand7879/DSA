//Date 16th july 2025
// Day Wednesday

public class Day29 {
    public static void main(String[] args) {
        
    }

    public int maximumLength(int[] nums) {
        // For each number parity (0 = even, 1 = odd),
        // we store the best length ending with that parity
        int[] evenSum = new int[2]; // evenSum[parity]: longest subseq ending in parity with even sum
        int[] oddSum = new int[2];  // oddSum[parity]: ... with odd sum

        int maxLen = 1;

        for (int num : nums) {
            int p = num % 2;

            // New values based on previous best subsequences
            int newEven = evenSum[p] + 1;       // Extend same parity (even sum)
            int newOdd = oddSum[1 - p] + 1;     // Extend alternate parity (odd sum)

            // Update
            evenSum[p] = Math.max(evenSum[p], newEven);
            oddSum[p] = Math.max(oddSum[p], newOdd);

            maxLen = Math.max(maxLen, Math.max(evenSum[p], oddSum[p]));
        }

        return maxLen;
    }
}
