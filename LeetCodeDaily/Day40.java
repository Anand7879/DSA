// Date: 27th July 2025
// Day: Sunday
import java.util.*;
public class Day40 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 1, 6, 5};
        System.out.println(countHillValley(nums));  // Output: 3
    }
    
    public static int countHillValley(int[] nums) {
        // Step 1: Flatten the array (remove consecutive duplicates)
        List<Integer> flat = new ArrayList<>();
        flat.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                flat.add(nums[i]);
            }
        }

        // Step 2: Count hills and valleys
        int count = 0;
        for (int i = 1; i < flat.size() - 1; i++) {
            int prev = flat.get(i - 1);
            int curr = flat.get(i);
            int next = flat.get(i + 1);

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                count++;
            }
        }

        return count;
    }

}

