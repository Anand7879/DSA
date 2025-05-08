package GFG160;

public class Problem3 {
    //You are given an array of integers arr[]. 
    //Your task is to reverse the given array.
    //Note: Modify the array in place.
    public static void main(String[] args) {
       int [] arr = {2,5,2,4,5,2};
        reverseArray(arr);
    }
    static void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        for(int i = 0; i<n/2; i++)
        {
            int temp = arr[n-1-i];
            arr[n-1-i] = arr[i];
            arr[i] = temp;
        }
    }
}
