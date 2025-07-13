//Date 12th july 2025
// Day Saturday
public class Day25 {
    public static void main(String[] args) {
        int n = 11, firstPlayer = 2, secondPlayer = 4;
        System.out.println(earliestAndLatest(n, firstPlayer, secondPlayer));
    }

    private static final int INF = 1000;
    // memo[l][r][k][0] = earliest round, memo[l][r][k][1] = latest round
    private static int[][][][] memo;

    public static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        memo = new int[n + 1][n + 1][n + 1][2];
        return solve(firstPlayer, n - secondPlayer + 1, n);
    }

    private static int[] solve(int l, int r, int k) {
        if (l == r) return new int[]{1, 1};
        if (l > r) return solve(r, l, k);

        if (memo[l][r][k][0] != 0) {
            return new int[]{memo[l][r][k][0], memo[l][r][k][1]};
        }

        int earliest = INF, latest = 0;
        int half = (k + 1) / 2;

        for (int i = 1; i <= l; i++) {
            for (int j = l - i + 1; j <= r - i; j++) {
                // Only valid next-round positions
                if (i + j < l + r - k / 2 || i + j > half) continue;

                int[] sub = solve(i, j, half);
                earliest = Math.min(earliest, sub[0] + 1);
                latest   = Math.max(latest,   sub[1] + 1);
            }
        }

        memo[l][r][k][0] = earliest;
        memo[l][r][k][1] = latest;
        return new int[]{earliest, latest};
    }
}

