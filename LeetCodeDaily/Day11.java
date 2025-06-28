// Date 28th june 2025
// Day saturday

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Day11 {
    public static void main(String[] args) {
       int[] nums = {2,1,3,3};
       int k = 2;
       System.out.println(maxSubsequence(nums, k));
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        // PriorityQueue to keep track of k largest elements with their indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]) // compare by value
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest if heap exceeds size k
            }
        }

        // Extract remaining k elements
        List<int[]> list = new ArrayList<>(minHeap);
        // Sort by original index to maintain order
        list.sort(Comparator.comparingInt(a -> a[1]));

        // Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];
        }

        return result;
    }
}
