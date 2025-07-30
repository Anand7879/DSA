//Date: 30th July 2025
// Day: Wednesday

public class Day43 {
    public static void main(String[] args) {
           int[] nums = {1, 2, 3, 3, 2, 2};
        int result = longestSubarray(nums);
        System.out.println("Longest subarray with max AND: " + result);
    }
    public static int longestSubarray(int[] nums) {
        int max = 0;

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int maxLength = 0;
        int currentLength = 0;

        // Step 2: Find longest consecutive subarray with all values equal to max
        for (int num : nums) {
            if (num == max) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}

