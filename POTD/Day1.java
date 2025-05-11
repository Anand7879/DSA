package POTD;

import java.util.ArrayList;
import java.util.*;

// Date 11/05/2025

//K-th Largest Sum Contiguous Subarray

// Description :- Given an array arr[] of size n, find the sum of the K-th largest sum 
// among all contiguous subarrays. In other words, 
// identify the K-th largest sum from all possible subarrays and return it.
public class Day1 {
    
    public static void main(String[] args) {
        int arr [] = {-2,-3,-1};
        K_th_Largest(arr, 1);
    }

    static void K_th_Largest(int arr[], int k){

       int n = arr.length;
       ArrayList<Integer> list =  new ArrayList<>();
       int sum = 0;
        
       for(int i = 0; i<n; i++)
       {
            list.add(arr[i]);
            sum = arr[i];
            for(int j = i+1; j<n; j++)
            {
                sum+=arr[j];
                list.add(sum);
            }
       }
       Collections.sort(list);
       System.out.println(list);

       System.out.println("The "+ k + "th Largest Sum Is: "+ list.get(list.size()-k));

    
    }

}
