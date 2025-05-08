package GFG160;

public class problem2 {
    // You are given an array arr[] of non-negative integers. \
    // Your task is to move all the zeros in the array to the right end 
    // while maintaining the relative order of the non-zero elements. 
    // The operation must be performed in place,
    //  meaning you should not use extra space for another array.
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0,8,5, 0};
        pushZerosToEnd(arr);
    }

   static void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
       
        int k = 0;
        for(int i= 0; i<n; i++)
        {
            if(arr[i]!=0)
            {
                arr[k++]=arr[i];  
            }
        }
        for(int j = k; j<n; j++)
        {
            arr[k++] = 0;
        }
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
    
}
