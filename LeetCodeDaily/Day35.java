// Date: 22nd July 2025
// Day: Tuesday
import java.util.*;
public class Day35 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        System.out.println("Maximum Erasure Value: " + maximumUniqueSubarray(nums)); // Output: 17
    }
    
    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int maxSum = 0, currentSum = 0;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }

        return maxSum;
    }

}
