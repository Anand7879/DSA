// Date 23th june 2025
// Day  monday

// A k-mirror number is a positive integer without leading zeros that reads the same both forward and backward in base-10 as well as in base-k.

// For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 1001 respectively, which read the same both forward and backward.
// On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100, which does not read the same both forward and backward.
// Given the base k and the number n, return the sum of the n smallest k-mirror numbers.

 

public class Day6 {
    public static void main(String[] args) {
        int k = 3, n = 7;

        System.out.println(kMirror(k,n));
    }

    public static String toBaseK(int number , int base)
    {
       StringBuilder sb = new StringBuilder();

       while (number > 0) {
           
        int remainder = number % base;
        sb.append(remainder);
        number/=base;
       }

       return sb.reverse().toString();
    }

     public static boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
         if(reverse.equals(s))
         {
            return true;
         }

         return false;
    }

     public static long kMirror(int k, int n) {
            
        int count = 0;
        int i = 1;
        long sum = 0;
        while (count<n){
            
         String str = toBaseK(i, k);
          
        //  String reverse = new StringBuilder(str).reverse().toString();

         if(isPalindrome(String.valueOf(i)) && isPalindrome(str))
         {
            System.out.println(i+" "+str);
             sum+=i;
             count++;
         }
         i++;
        }

        return sum;
     }
}
