import java.util.Arrays;
import java.util.Comparator;

public class Day47 {
     public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // Sort by position
        Arrays.sort(fruits, Comparator.comparingInt(a -> a[0]));
        int n = fruits.length;

        // Extract positions and build prefix sums of amounts
        int[] pos = new int[n];
        long[] prefix = new long[n]; // use long to avoid overflow if amounts are large
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefix[i] = fruits[i][1] + (i > 0 ? prefix[i - 1] : 0);
        }

        // Helper to get sum in interval [l..r] in the sorted array
        // assumes 0 <= l <= r < n
        java.util.function.BiFunction<Integer, Integer, Long> intervalSum = (l, r) -> {
            if (l > r) return 0L;
            return prefix[r] - (l > 0 ? prefix[l - 1] : 0);
        };

        long ans = 0;

        // Case 1: only go left (no turn)
        // For any leftmost reachable position L where startPos - L <= k, we can take all fruits between L and the rightmost <= startPos
        int idxRightOfStart = upperBound(pos, startPos) - 1; // rightmost index with pos[i] <= startPos
        for (int i = 0; i <= idxRightOfStart; i++) {
            int d = startPos - pos[i];
            if (d > k) continue;
            // interval is [i .. idxRightOfStart]
            ans = Math.max(ans, intervalSum.apply(i, idxRightOfStart));
        }

        // Case 2: only go right (no turn)
        int idxLeftOfStart = lowerBound(pos, startPos); // leftmost index with pos[i] >= startPos
        for (int i = idxLeftOfStart; i < n; i++) {
            int d = pos[i] - startPos;
            if (d > k) continue;
            // interval is [idxLeftOfStart .. i]
            ans = Math.max(ans, intervalSum.apply(idxLeftOfStart, i));
        }

        // Case 3: go left first, then right
        // Iterate left endpoint i (pos[i] <= startPos)
        for (int i = 0; i < n; i++) {
            if (pos[i] > startPos) break;
            int dL = startPos - pos[i];
            if (2 * dL > k) continue; // can't even go left and return
            int rem = k - 2 * dL; // remaining to go right from startPos
            int farRight = startPos + rem;
            // find rightmost j with pos[j] <= farRight
            int j = upperBound(pos, farRight) - 1;
            if (j >= i) {
                ans = Math.max(ans, intervalSum.apply(i, j));
            }
        }

        // Case 4: go right first, then left
        for (int i = n - 1; i >= 0; i--) {
            if (pos[i] < startPos) break;
            int dR = pos[i] - startPos;
            if (2 * dR > k) continue;
            int rem = k - 2 * dR;
            int farLeft = startPos - rem;
            // find leftmost j with pos[j] >= farLeft
            int j = lowerBound(pos, farLeft);
            if (j <= i) {
                ans = Math.max(ans, intervalSum.apply(j, i));
            }
        }

        return (int) ans; // constraints guarantee fits in int, but we used long to accumulate safely
    }

    // Returns leftmost index i such that pos[i] >= target. If none, returns n.
    private static int lowerBound(int[] pos, int target) {
        int l = 0, r = pos.length; // [l, r)
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (pos[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // Returns leftmost index i such that pos[i] > target. If none, returns n.
    private static int upperBound(int[] pos, int target) {
        int l = 0, r = pos.length; // [l, r)
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (pos[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // Example usage / test
    public static void main(String[] args) {
        int[][] fruits = {
            {2, 4},
            {4, 3},
            {5, 2},
            {8, 1},
            {10, 5}
        };
        int startPos = 5;
        int k = 7;
        int result = maxTotalFruits(fruits, startPos, k);
        System.out.println("Max fruits collected: " + result); // expected 11
    }
}
