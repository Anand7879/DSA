//Date: 1st August 2025
// Day: friday

import java.util.*;
public class Day45 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
    
}

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) return triangle;

        triangle.add(new ArrayList<>(Arrays.asList(1))); // first row

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1); // first element

            // interior elements
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }

            curr.add(1); // last element
            triangle.add(curr);
        }

        return triangle;
    }

    // For testing
}

