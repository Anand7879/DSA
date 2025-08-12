//Date: 10th August 2025
// Day: Sunday
import java.util.*;
public class Day54 {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(reorderedPowerOf2(n));
    }

    public static boolean reorderedPowerOf2(int n) {
        // Get the digit frequency of the input number
        int[] digitCount = getDigitCount(n);
        
        // Check all powers of 2 up to 10^9 (since n <= 10^9)
        // 2^29 = 536,870,912 and 2^30 = 1,073,741,824 > 10^9
        for (int i = 0; i < 30; i++) {
            int powerOf2 = 1 << i; // Calculate 2^i
            if (Arrays.equals(digitCount, getDigitCount(powerOf2))) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper method to get digit frequency count
    private static int[] getDigitCount(int num) {
        int[] count = new int[10]; // digits 0-9
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }
}

// Alternative solution using string sorting approach
class SolutionAlternative {
    public boolean reorderedPowerOf2(int n) {
        String sorted = sortDigits(n);
        
        for (int i = 0; i < 30; i++) {
            int powerOf2 = 1 << i;
            if (sorted.equals(sortDigits(powerOf2))) {
                return true;
            }
        }
        
        return false;
    }
    
    private String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
