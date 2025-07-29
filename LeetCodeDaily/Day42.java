// Date: 29th July 2025
// Day: Tuesday
import java.util.*;

public class Day42 {
    public static void main(String[] args) {
        
    }

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] lastSeen = new int[32];  // Stores the farthest index a bit is set
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Update last seen positions for each bit
            for (int b = 0; b < 32; b++) {
                if (((nums[i] >> b) & 1) == 1) {
                    lastSeen[b] = i;
                }
            }

            // Get the farthest right index we need to reach to cover all OR bits
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                maxReach = Math.max(maxReach, lastSeen[b]);
            }

            result[i] = maxReach - i + 1;
        }

        return result;
    }
}  
