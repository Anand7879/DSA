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

     public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        ArrayList<Long> list = new ArrayList<>();

        for(int i = 0; i<nums1.length; i++)
        {
            for(int j = 0; j<nums2.length; j++)
            {
                long temp = 1L * nums1[i] * nums2[j];  // cast to long to prevent overflow
                list.add(temp);   
            }
        }

        Collections.sort(list);

       return list.get((int)k - 1);
    }
}
