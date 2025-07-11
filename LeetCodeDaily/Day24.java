//Date 11th july 2025
// Day Friday

public class Day24 {
    public static void main(String[] args) {
        
    }

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap for available rooms by index
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // Min-heap for busy rooms: [endTime, roomIndex]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]); // break tie by room index
            return Long.compare(a[0], b[0]);
        });

        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int duration = meeting[1] - meeting[0];

            // Free up rooms that are done before the meeting starts
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // Assign meeting to the room with the smallest index
                int room = availableRooms.poll();
                meetingCount[room]++;
                busyRooms.offer(new long[]{start + duration, room});
            } else {
                // No rooms are free: delay meeting until the earliest room is free
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                meetingCount[room]++;
                busyRooms.offer(new long[]{newStart + duration, room});
            }
        }

        // Find the room with the maximum meetings
        int maxMeetings = 0, result = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                result = i;
            }
        }

        return result;
    }
}
