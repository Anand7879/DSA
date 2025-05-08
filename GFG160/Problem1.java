package GFG160;

import java.util.Arrays;
import java.util.HashSet;

public class Problem1 {
    //Given an array of positive integers arr[],
    //return the second largest element from the array. 
    //If the second largest element doesn't exist then return -1.
    //Note: The second largest element should not be equal to the largest element.

    public static void main(String[] args) {
        int[] arr = {10,10,10};
        System.out.println(SecondLargest(arr));
    }
    static int SecondLargest(int [] arr)
    {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int num : arr) {
            uniqueNumbers.add(num);
        }
        Integer[] integerArray = uniqueNumbers.toArray(new Integer[0]);
        Arrays.sort(integerArray);

        if(integerArray.length<2)
        {
            return -1;
        }
        else
           return integerArray[integerArray.length-2];
    }
}
