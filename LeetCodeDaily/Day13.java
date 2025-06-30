// Date 30th june 2025
// Day Monday

import java.util.HashMap;
import java.util.Map;

public class Day13 {
    public static void main(String[] args) {
        
    }

     public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        
        // Check each number and its neighbor (num + 1)
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int currentLength = map.get(key) + map.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}
