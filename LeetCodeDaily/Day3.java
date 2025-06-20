// Date 20th june 2025
// Day Friday

// You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:
// 'N' : Move north by 1 unit.'S' : Move south by 1 unit.'E' : Move east by 1 unit.'W' : Move west by 1 unit.
// Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.
// Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.
// The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.
 
// Example 1:
// Input: s = "NWSE", k = 1
// Output: 3

import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        System.out.print("Enter K : ");
        int k = sc.nextInt();

        Day3 obj = new Day3();
        int result = obj.maxDistance(str, k);
        System.out.println("Max Manhattan Distance: " + result);
    }

    public int maxDistance(String s, int k) {
        // Try all 4 helpful direction pairs
        int max = 0;

        char[][] preferredPairs = {
            {'N', 'E'},
            {'N', 'W'},
            {'S', 'E'},
            {'S', 'W'}
        };

        for (char[] pair : preferredPairs) {
            max = Math.max(max, simulate(s, k, pair[0], pair[1]));
        }

        return max;
    }

    public int simulate(String s, int k, char goodY, char goodX) {
        int x = 0, y = 0;
        int maxDist = 0;
        int remainingChanges = k;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean changed = false;

            // If this move is against our goal and we have changes left
            if (remainingChanges > 0) {
                if (ch == opposite(goodX)) {
                    ch = goodX;
                    remainingChanges--;
                    changed = true;
                } else if (ch == opposite(goodY)) {
                    ch = goodY;
                    remainingChanges--;
                    changed = true;
                }
            }

            // Apply movement
            switch (ch) {
                case 'N': y += 1; break;
                case 'S': y -= 1; break;
                case 'E': x += 1; break;
                case 'W': x -= 1; break;
            }

            maxDist = Math.max(maxDist, Math.abs(x) + Math.abs(y));
        }

        return maxDist;
    }

    public char opposite(char ch) {
        switch (ch) {
            case 'N': return 'S';
            case 'S': return 'N';
            case 'E': return 'W';
            case 'W': return 'E';
        }
        return ch;
    }
}