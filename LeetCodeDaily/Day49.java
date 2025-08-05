//Date: 5th August 2025
// Day: Tuesday

public class Day49 {
    public static void main(String[] args) {
        
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
