// Date 19th june 2025
// Day Thursday

// You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
// Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: nums = [3,6,1,2,5], k = 2
// Output: 2

import java.util.ArrayList;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        
        // int[] nums = {3,6,1,2,5};
         int[] nums = {2,2,4,5};
        int k = 0;
        int n = partitionArray(nums, k);
        System.out.println(n);
    }

    public static int partitionArray(int[] nums, int k) {
          
        Arrays.sort(nums);
       int n = nums.length;
       int count = 0;
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int i = 0;
        while (i < n) {
            // ArrayList<Integer> subList = new ArrayList<>();
            // subList.add(nums[i]);
            int j = i + 1;

            while (j < n && Math.abs(nums[j] - nums[i]) <= k) {
                // subList.add(nums[j]);
                j++;
            }

            // list.add(subList);
            count++;
            i = j;
        }

        // System.out.println(list);

        return count;

    }
    
}
