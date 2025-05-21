package POTD;

import java.util.Arrays;

// Problem : Meeting Rooms III

// Description :
//  You are given an integer n representing the number of rooms numbered from 0 to n - 1. Additionally, 
// you are given a 2D integer array meetings[][] where meetings[i] = [starti, endi] indicates that a meeting is scheduled during the half-closed time interval [starti, endi).
//  All starti values are unique.

// Meeting Allocation Rules:

// When a meeting starts, assign it to the available room with the smallest number.
// If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting retains its original duration.
// When a room becomes free, assign it to the delayed meeting with the earliest original start time.
// Determine the room number that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.

public class Day2 {
    public static void main(String[] args) {
        int [][] meetings =   {{0, 6}, {2, 3},{3, 7},{4,8},{6,8}};
        int n = 2;
        mostBooked(n, meetings);

    }
    public static void mostBooked(int n, int[][] meetings) {

         Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

         int delay = 0;
         
        
         for(int i = 0; i<meetings.length; i++)
         {
              for(int j = 0; j<meetings[i].length; j++ )
              {
                  
              }
         }
}
}
