public class Day58 {
    public static void main(String[] args) {
        
    }

    public static String largestGoodInteger(String num) {
         char maxDigit = 0; // Initialize to null character
    
    // Iterate through the string
    for (int i = 0; i <= num.length() - 3; i++) {
        char c = num.charAt(i);
        
        // Check if all 3 characters are the same
        if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
            // Update maxDigit if current digit is larger
            if (c > maxDigit) {
                maxDigit = c;
            }
        }
    }
    
    // Return empty string if no good integer found, otherwise repeat the digit 3 times
    return maxDigit == 0 ? "" : String.valueOf(maxDigit).repeat(3); 
    }
}
