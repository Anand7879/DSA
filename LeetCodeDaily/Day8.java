// Date 25th june 2025
// Day wednesday

// Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k,
//  return the kth (1-based) smallest product of nums1[i] * nums2[j]
//   where 0 <= i < nums1.length and 0 <= j < nums2.length.

import java.util.*;
public class Day8 {
    public static void main(String[] args) {
        // int[] nums1 = {2,5};
        // int[] nums2 = {3,4};
        // long  k = 2;

         int[] nums1 = {-4,-2,0,3};
        int[] nums2 = {2,4};
        long  k = 6;

        System.out.println(kthSmallestProduct(nums1, nums2, k));
    }

    //  public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
    //     ArrayList<Long> list = new ArrayList<>();

    //     for(int i = 0; i<nums1.length; i++)
    //     {
    //         for(int j = 0; j<nums2.length; j++)
    //         {
    //             long temp = 1L * nums1[i] * nums2[j];  // cast to long to prevent overflow
    //             list.add(temp);   
    //         }
    //     }

    //     Collections.sort(list);

    //    return list.get((int)k - 1);
    // }


// Optimise Solution

     public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -1_000_000_0000L;  // Minimum possible product
        long right = 1_000_000_0000L;  // Maximum possible product

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countPairs(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static long countPairs(int[] nums1, int[] nums2, long target) {
        long count = 0;

        for (int a : nums1) {
            if (a == 0) {
                if (target >= 0) {
                    count += nums2.length; // all zero products <= any positive target
                }
                // if target < 0, 0 > target is false, so count += 0
            } else if (a > 0) {
                // Find max j such that a * nums2[j] <= target
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if ((long)a * nums2[m] <= target) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                count += l;
            } else { // a < 0
                // Find min j such that a * nums2[j] <= target
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if ((long)a * nums2[m] <= target) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - l;
            }
        }

        return count;
    }   
}
