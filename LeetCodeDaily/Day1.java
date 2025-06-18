// Date 18th june 2025
// Day Wednesday

// You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.
// Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:
// The difference between any two elements in one array is less than or equal to k.

import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
      
    //   int[] nums = {1,3,4,8,7,9,3,5,1};
     int[] nums = {2,4,2,2,5,2};
      int k = 2;

      int[][] result = divideArray(nums,k);

      for(int i = 0; i<result.length; i++){
         for(int j = 0; j<result[0].length; j++){
            System.out.print(result[i][j]+" ");
         }
         System.out.println();
      }

    }
     public static int[][] divideArray(int[] nums, int k) {

        int n = nums.length;
        int a = n/3;
        int[][] res = new int[a][3];
         int idx = 0;        
         
         Arrays.sort(nums);

        for(int i = 0; i<n; i+=3)
        {
            if(i+2 >= n){
             return new int[0][0];
            }
            
            int min = nums[i];
            int mid = nums[i+1];
            int max = nums[i+2];

            if(max-min > k)
            return new int[0][0];

            res[idx][0] = min;
            res[idx][1] = mid;
            res[idx][2] = max;
            idx++;
        }

        return res;
        
    }
    
}
