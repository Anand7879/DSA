public class Day57 {
    public static void main(String[] args) {
        
    }
      public boolean isPowerOfThreeOptimal(int n) {
        // 3^19 = 1162261467 is the largest power of 3 within int range
        // If n is a power of 3, then 3^19 should be divisible by n
        return n > 0 && 1162261467 % n == 0;
    }
}
