public class Day48 {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(totalFruit(fruits)); // output: 3

        int[] fruits2 = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(fruits2)); // output: 4 (subarray [2,3,2,2] or [3,2,2])
    }
    }

    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;

        int type1 = -1, type2 = -1; // the two fruit types in window
        int lastFruit = -1;         // most recent fruit type
        int lastFruitCount = 0;     // how many times lastFruit appeared consecutively at the end
        int currentWindow = 0;      // current valid window size
        int max = 0;

        for (int f : fruits) {
            if (f == type1 || f == type2) {
                // extend window
                currentWindow++;
            } else {
                // new fruit type enters: window shrinks to the last contiguous block of lastFruit plus this new one
                currentWindow = lastFruitCount + 1;
                type1 = lastFruit;
                type2 = f;
            }

            if (f == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                lastFruit = f;
            }

            max = Math.max(max, currentWindow);
        }

        return max;
    }
}

