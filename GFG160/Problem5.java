package GFG160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {

    // You are given an array of integer arr[] where each number /
    // represents a vote to a candidate. 
    // Return the candidates that have votes greater than one-third of the total votes, 
    // If there's not a majority vote, return an empty array. 
    
    // Note: The answer should be returned in an increasing format.


    public static void main(String[] args) {
        int [] nums = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        // int [] nums = {3,2,3};
        // int [] nums = {1,1,1,3,3,2,2,2};
        // int [] nums = {4};
        // findMajority(nums);
        System.out.println(findMajority(nums));
        
    }
    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        Arrays.sort(nums);
        int TotalCount = nums.length;
    
        List<Integer> result = new ArrayList<>();
        int temp = nums[0];
        int voteCount = 0; 
        for(int i = 0; i<nums.length; i++)
        {
             if(nums[i]==temp)
             {
                voteCount++;
             }else{
                 if(voteCount > (TotalCount/3))
                 {
                    result.add(temp);
                 } 

                 temp = nums[i]; 
                voteCount = 1;
             }

             if(i==nums.length-1)
             {
                if(voteCount > (TotalCount/3))
                {
                    result.add(temp);
                }
             }

        }
        return result;
    }

}
