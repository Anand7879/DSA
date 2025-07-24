// Date: 24th July 2025
// Day: Thursday

import java.util.*;

public class Day37{
    public static void main(String[] args) {
        // Sample test case
        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = {
            {0, 1},
            {1, 2},
            {1, 3},
            {3, 4}
        };

        Solution sol = new Solution();
        int result = sol.minimumScore(nums, edges);
        System.out.println("Minimum Score: " + result);
    }
}

class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] xor;
    int[] in;
    int[] out;
    int timer = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        this.tree = new ArrayList[n];
        this.xor = new int[n];
        this.in = new int[n];
        this.out = new int[n];

        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        dfs(0, -1);

        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = i, b = j;
                int xorA = xor[a], xorB = xor[b];

                if (isAncestor(a, b)) {
                    xorA = xor[b];
                    xorB = xor[a] ^ xor[b];
                } else if (isAncestor(b, a)) {
                    xorA = xor[a];
                    xorB = xor[b] ^ xor[a];
                }

                int xorRest = xor[0] ^ xorA ^ xorB;
                int max = Math.max(xorA, Math.max(xorB, xorRest));
                int min = Math.min(xorA, Math.min(xorB, xorRest));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    void dfs(int node, int parent) {
        xor[node] = nums[node];
        in[node] = ++timer;
        for (int child : tree[node]) {
            if (child == parent) continue;
            dfs(child, node);
            xor[node] ^= xor[child];
        }
        out[node] = ++timer;
    }

    boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }
}
