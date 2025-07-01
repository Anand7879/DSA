// Date 29th june 2025
// Day sunday

import java.util.Arrays;

public class Day12 {
    
   public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int  target = 9;

        System.out.println(numSubseq(nums, target));

   }

    public static int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;
        
        // Precompute powers of 2
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1, result = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
