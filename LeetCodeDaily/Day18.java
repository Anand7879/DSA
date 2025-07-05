// Date 5th july 2025
// Day Saturday
import java.util.*;
public class Day18 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4};
        System.out.println(findLucky(arr));
    }
         public static int findLucky(int[] arr) {
             HashMap<Integer,Integer> freqMap = new HashMap<>();
             for (int i : arr) {
                freqMap.put(i, freqMap.getOrDefault(i,0)+1);
             }
        int largestLucky = -1;

        for (int key : freqMap.keySet()) {
            if(key==freqMap.get(key))
            {
                largestLucky = Math.max(largestLucky, key);
            }
        }

        return largestLucky;
    }

}
