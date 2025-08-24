public class Day68 {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
         int maxLen = 0;
        int left = 0;
        int zeroIndex = -1;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = zeroIndex + 1;
                zeroIndex = right;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        
        return maxLen;
    }
}
