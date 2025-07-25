// Date: 25th July 2025
// Day: Friday
public class Day38 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;

        // Use array to track seen elements (-100 to 100 => 201 range)
        boolean[] seen = new boolean[201]; // Index offset: x + 100
        int sum = 0;

        for (int x : nums) {
            max = Math.max(max, x);
            if (x > 0 && !seen[x + 100]) {
                seen[x + 100] = true;
                sum += x;
            }
        }

        return (max <= 0) ? max : sum;
    }
}

