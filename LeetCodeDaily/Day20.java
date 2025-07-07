//Date 7th july 2025
// Day Monday

import java.util.Arrays;
import java.util.PriorityQueue;

public class Day20 {
    public static void main(String[] args) {
       int[][] events = {{1,2},{2,3},{3,4}};
       System.out.println(maxEvents(events));
    }
    public static int maxEvents(int[][] events) {
        // Sort events by their start day
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap based on event end day
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 1;
        int i = 0;
        int attended = 0;
        int n = events.length;

        // Find the last day among all events
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        // Iterate through each day
        for (day = 1; day <= maxDay; day++) {
            // Add events starting today to the heap
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove all events that have already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll(); // Attend this event
                attended++;
            }
        }

        return attended;
    }

}
