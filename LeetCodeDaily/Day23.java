//Date 10th july 2025
// Day Thursday
public class Day23 {
    public static void main(String[] args) {
        int eventTime = 5;
        int[] startTime = {1,3}, endTime = {2,5};
    }
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        // Step 1: Calculate gaps
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        // Step 2: Build prefix and suffix max arrays
        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];

        maxLeft[0] = gaps[0];
        for (int i = 1; i <= n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }

        maxRight[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }

        int maxFree = 0;

        // Step 3: Try removing each meeting once
        for (int i = 0; i < n; i++) {
            int duration = endTime[i] - startTime[i];
            int adjacentGap = gaps[i] + gaps[i + 1];

            int maxOtherGap = 0;
            if (i > 0) maxOtherGap = Math.max(maxOtherGap, maxLeft[i - 1]);
            if (i + 2 <= n) maxOtherGap = Math.max(maxOtherGap, maxRight[i + 2]);

            if (duration <= maxOtherGap) {
                maxFree = Math.max(maxFree, adjacentGap + duration);
            } else {
                maxFree = Math.max(maxFree, adjacentGap);
            }
        }

        return maxFree;
    }
}

