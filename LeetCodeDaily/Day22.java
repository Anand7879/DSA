//Date 9th july 2025
// Day wednesday

public class Day22 {
    public static void main(String[] args) {
        
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        // Step 1: Create the gaps array
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0]; // time before the first meeting
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1]; // time between meetings
        }
        gaps[n] = eventTime - endTime[n - 1]; // time after the last meeting

        // Step 2: Sliding window of size k + 1 over the gaps array
        int windowSum = 0;
        for (int i = 0; i <= k && i < gaps.length; i++) {
            windowSum += gaps[i];
        }

        int maxFree = windowSum;

        for (int i = k + 1; i < gaps.length; i++) {
            windowSum += gaps[i] - gaps[i - (k + 1)];
            maxFree = Math.max(maxFree, windowSum);
        }

        return maxFree;
    }
}
