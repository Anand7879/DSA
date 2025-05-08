package GFG160;

import java.util.Vector;

public class Problem4 {
    //Given an array arr[].
    //Rotate the array to the left (counter-clockwise direction) by d steps, 
    //where d is a positive integer. Do the mentioned change in the array in place.
    //Note: Consider the array as circular.
    public static void main(String[] args) {
        int [] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        rotateArr(arr, 3);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    static void rotateArr(int arr[], int d) {
        
            int n = arr.length;
            if(d>=n)
            {
                d = d%n;
            }
            
          Vector<Integer> storedElements = new Vector<>();
           for(int i = 0; i<d;i++)
           {
              storedElements.add(arr[i]);
           }
            int k = 0;
            for(int i = d; i<n; i++)
            {
                arr[k++] = arr[i];
            }
           
           for(int element : storedElements)
           {
               arr[k++] = element;
           }
        
    }
    
}
