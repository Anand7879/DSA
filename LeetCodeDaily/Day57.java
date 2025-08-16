//Date: 13th August 2025
// Day: Wednesday

public class Day57 {
    public static void main(String[] args) {
         int[] testCases = {1, 3, 9, 27, 0, -1, 2, 4, 6, 243, 244};

          for (int n : testCases) {
            boolean opt = isPowerOfThreeOptimal(n);
            System.out.println(opt);
            System.out.println();
          
        }
       
    }
      public static boolean isPowerOfThreeOptimal(int n) {
        // 3^19 = 1162261467 is the largest power of 3 within int range
        // If n is a power of 3, then 3^19 should be divisible by n
        return n > 0 && 1162261467 % n == 0;
    }
}
