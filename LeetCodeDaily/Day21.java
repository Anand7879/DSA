//Date 8th july 2025
// Day Tuesday
import java.util.*;
public class Day21 {
    public static void main(String[] args) {
        
    }
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start time
        int n = events.length;
        int[] startTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = events[i][0];
        }

        // DP memo table: dp[i][k] = max value from index i with k events remaining
        Integer[][] memo = new Integer[n][k + 1];
        return dfs(0, k, events, startTimes, memo);
    }

    private static int dfs(int index, int k, int[][] events, int[] startTimes, Integer[][] memo) {
        if (index == events.length || k == 0) return 0;
        if (memo[index][k] != null) return memo[index][k];

        // Option 1: Skip this event
        int skip = dfs(index + 1, k, events, startTimes, memo);

        // Option 2: Attend this event
        // Find the next non-overlapping event using binary search
        int nextIndex = binarySearch(startTimes, events[index][1]);
        int take = events[index][2] + dfs(nextIndex, k - 1, events, startTimes, memo);

        return memo[index][k] = Math.max(skip, take);
    }

    // Binary search for next non-overlapping event
    private static int binarySearch(int[] startTimes, int endTime) {
        int left = 0, right = startTimes.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (startTimes[mid] > endTime) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}

