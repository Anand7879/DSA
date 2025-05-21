package Recursiion;

public class R3 {
    public static void main(String[] args) {
    //    System.out.println(NnumbersSum(4));
    //     System.out.println(fact(5));
    int [] arr  = {1,2,3,4,5};
      reverse(arr, 5);

        
    }
      public static int NnumbersSum(int N) {
        //your code goes here
        if(N==1)
        return 1;
        return N+NnumbersSum(N-1);
       
    }

    public static int fact(int n)
    {
        if(n==1)
        return 1;

        return n*fact(n-1);
    }
     public static void reverse(int[] arr, int n) {

       for(int i = 0; i<n/2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
        }
   
    }
    
}
