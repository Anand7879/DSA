//Date: 5th August 2025
// Day: Tuesday

public class Day49 {
    public static void main(String[] args) {
        int[] fruits = {4, 2, 5};
int[] baskets = {3, 5, 4};
System.out.println(numOfUnplacedFruits(fruits, baskets));  // outputs 1

    }
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;
        
        for (int fruit : fruits) {
            boolean placed = false;
            for (int i = 0; i < n; i++) {
                if (!used[i] && baskets[i] >= fruit) {
                    used[i] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) unplaced++;
        }
        return unplaced;
    }
}
