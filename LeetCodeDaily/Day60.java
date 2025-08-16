public class Day60 {
    public static void main(String[] args) {
        
    }

    public int maximum69Number(int num) {
        int temp = num;
        int digitPosition = 0;
        int sixPosition = -1;
        
        // Find the position of the leftmost '6'
        while (temp > 0) {
            if (temp % 10 == 6) {
                sixPosition = digitPosition;
            }
            temp /= 10;
            digitPosition++;
        }
        
        // If we found a '6', add 3 * 10^position to convert it to '9'
        if (sixPosition != -1) {
            num += 3 * Math.pow(10, sixPosition);
        }
        
        return num;
    }
}
