//Date 16th july 2025
// Day Wednesday

public class Day29 {
    public static void main(String[] args) {
        
    }

    public int maximumLength(int[] nums) {
        // Strategy 1: All adjacent pairs have the same parity
        int sameParityLength = 1;
        int lastSame = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2) == (lastSame % 2)) {
                sameParityLength++;
                lastSame = nums[i];
            }
        }

        // Strategy 2: All adjacent pairs have different parity
        int altParityLength = 1;
        int lastAlt = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2) != (lastAlt % 2)) {
                altParityLength++;
                lastAlt = nums[i];
            }
        }

        return Math.max(sameParityLength, altParityLength);
    }
}

