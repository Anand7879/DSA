public class Day63 {
    public static void main(String[] args) {
        
    }
 public static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long consecutiveZeros = 0;
        
        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
                result += consecutiveZeros;
            } else {
                consecutiveZeros = 0;
            }
        }
        
        return result;
    }

}
