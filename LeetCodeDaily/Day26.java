//Date 13th july 2025
// Day Sunday
import java.util.*;
public class Day26 {
    public static void main(String[] args) {
       int[] players = {4,7,9}, trainers = {8,2,5,8};
       System.out.println(matchPlayersAndTrainers(players, trainers));
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0, matches = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return matches;
    }
}

