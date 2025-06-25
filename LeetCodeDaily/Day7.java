// Date 24th june 2025
// Day tuesday


// You are given a 0-indexed integer array nums and two integers key and k. 
// A k-distant index is an index i of nums for which there exists at least one index j 
// such that |i - j| <= k and nums[j] == key.
// Return a list of all k-distant indices sorted in increasing order.

import java.util.*;

public class Day7 {
    public static void main(String[] args) {
        // int[] nums = {3,4,9,1,3,9,5};
        // int key = 9, k = 1;

         int[] nums = {2,2,2,2,2};
        int key = 2, k = 2;
        System.out.println("K-Distant Elements are : ");
        System.out.println(findKDistantIndices(nums, key, k));
    }   

      public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        ArrayList<Integer> indices = new ArrayList<>();
         
        for(int i = 0; i<nums.length; i++)
        {
             if(nums[i]==key)
             {
                indices.add(i);
             }
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i<nums.length; i++)
       {
            boolean flag = false;

            for (Integer index : indices) {
                
                if(Math.abs(i-index) <=k){
                   flag = true;
                   result.add(i);
                   break;
                }
            }
       }

       Collections.sort(result);
       return result;

    }
}
