//Date: 12th August 2025
// Day: Tuesday

public class Day56 {

    public static void main(String[] args) {
        int n = 5,x=6;
        System.out.println(numberOfWays(n, x));
    }

    public static int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        int base = 1;
        while (true) {
            int power = (int) Math.pow(base, x);
            if (power > n) break;
            
            for (int sum = n; sum >= power; sum--) {
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
            base++;
        }
        
        return dp[n];
    }
}

