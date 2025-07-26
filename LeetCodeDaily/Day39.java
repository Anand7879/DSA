// Date: 26th July 2025
// Day: Saturday

import java.util.ArrayList;
import java.util.List;

public class Day39 {
    public static void main(String[] args) {
        
    }

  public static long maxSubarrays(int n, int[][] conflictingPairs) {
    long valid = 0;
    int maxLeft = 0, secondMaxLeft = 0;
    long[] gains = new long[n + 1];
    List<Integer>[] conflicts = new List[n + 1];
    for (int i = 0; i <= n; ++i)
      conflicts[i] = new ArrayList<>();

    for (int[] pair : conflictingPairs) {
      int a = pair[0], b = pair[1];
      int r = Math.max(a, b), l = Math.min(a, b);
      conflicts[r].add(l);
    }

    for (int right = 1; right <= n; right++) {
      for (int l : conflicts[right]) {
        if (l > maxLeft) {
          secondMaxLeft = maxLeft;
          maxLeft = l;
        } else if (l > secondMaxLeft) {
          secondMaxLeft = l;
        }
      }
      valid += right - maxLeft;
      gains[maxLeft] += maxLeft - secondMaxLeft;
    }

    long bestGain = 0;
    for (long g : gains) bestGain = Math.max(bestGain, g);
    return valid + bestGain;
  }
}

