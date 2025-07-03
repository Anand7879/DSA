// Date 3rd july 2025
// Day Thursday
public class Day16 {
    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
    }

    public char kthCharacter(int k) {
        // The k-th character is 'a' + number of 1-bits in (k - 1)
        return (char) ('a' + Integer.bitCount(k - 1));
    }

    
}
