//Date: 2nd August 2025
// Day: Saturday

import java.util.*;

public class Day46 {
    public static void main(String[] args) {

        int[] basket1 = {1, 2, 2};
        int[] basket2 = {2, 1, 1};

        System.out.println(minCost(basket1, basket2)); // Output: 1
    }

     public static long minCost(int[] basket1, int[] basket2) {

        // Frequency Count For each Fruit
        Map<Integer,Integer> freq = new HashMap<>();

        for (int fruit : basket1) {
            freq.put(fruit, freq.getOrDefault(fruit,0)+1);
        }
        for (int fruit : basket2) {
            freq.put(fruit, freq.getOrDefault(fruit,0)+1);
        }

        // If frequncy count is odd then not possible 

        for (int count : freq.values()) {
            if(count%2!=0){
                return -1;
            }
        }

        // Count Frequency of each fruits in both basket

        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        for (int fruit : basket1)
            count1.put(fruit, count1.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2)
            count2.put(fruit, count2.getOrDefault(fruit, 0) + 1);

        List<Integer> toSwap = new ArrayList<>();

        for (int fruit : freq.keySet()) {
            int f1 = count1.getOrDefault(fruit, 0);
            int f2 = count2.getOrDefault(fruit, 0);
            int diff = f1 - f2;

            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                if (diff > 0) toSwap.add(fruit);       // surplus in basket1
                else toSwap.add(-fruit);                // surplus in basket2 (marked negative)
            }
        }

        if (toSwap.isEmpty()) return 0;

        Collections.sort(toSwap); // negative values (basket2) will come first

        int minFruit = Integer.MAX_VALUE;
        for (int f : freq.keySet()) {
            minFruit = Math.min(minFruit, f);
        }

        long cost = 0;
        int n = toSwap.size();
        for (int i = 0; i < n / 2; i++) {
            int a = Math.abs(toSwap.get(i));
            int b = Math.abs(toSwap.get(n - 1 - i));
            cost += Math.min(Math.min(a, b), 2 * minFruit);
        }

        return cost;

    }
}
