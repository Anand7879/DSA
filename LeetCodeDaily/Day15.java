// Date 2nd july 2025
// Day Thursday
import java.util.*;
public class Day15 {
    public static void main(String[] args) {
        String word = "aabbccdd";
        int k = 7;

        System.out.println(possibleStringCount(word, k));
    }

    private static final int MOD = 1_000_000_007;

    public static int possibleStringCount(String word, int k) {
        List<Integer> groups = getConsecutiveLetters(word);
        // total combinations = product of group lengths
        long total = groups.stream().mapToLong(g -> g).reduce(1L, (a, b) -> a * b % MOD);
        if (k <= groups.size()) return (int) total;

        int m = groups.size();
        int[] dp = new int[k];
        dp[0] = 1;

        // DP builds counts of strings shorter than k
        for (int i = 0; i < m; ++i) {
            int[] ndp = new int[k];
            int window = 0, group = groups.get(i);
            for (int j = i; j < k; ++j) {
                ndp[j] = window;
                window = (window + dp[j]) % MOD;
                if (j >= group) window = (window - dp[j - group] + MOD) % MOD;
            }
            dp = ndp;
        }

        int invalid = 0;
        for (int v : dp) invalid = (invalid + v) % MOD;

        // valid = total – invalid
        return (int) ((total - invalid + MOD) % MOD);
    }

    private static List<Integer> getConsecutiveLetters(String s) {
        List<Integer> groups = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cnt++;
            else { groups.add(cnt); cnt = 1; }
        }
        groups.add(cnt);
        return groups;
    }
}
