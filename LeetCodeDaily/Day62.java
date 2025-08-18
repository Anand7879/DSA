//Date: 18th August 2025
// Day: Moday
import java.util.*;
public class Day62 {
    public static void main(String[] args) {
        int[] cards = {4,1,8,7};
        System.out.println(judgePoint24(cards));
    }

    private static final double EPS = 1e-6;
    
    public static boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return backtrack(nums);
    }
    
    private static boolean backtrack(List<Double> nums) {
        // Base case: if only one number left, check if it's close to 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < EPS;
        }
        
        // Try all pairs of numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                double a = nums.get(i);
                double b = nums.get(j);
                
                // Create list with remaining numbers (exclude the pair)
                List<Double> remaining = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        remaining.add(nums.get(k));
                    }
                }
                
                // Try all operations between a and b
                List<Double> candidates = new ArrayList<>();
                
                // Addition and multiplication (commutative)
                candidates.add(a + b);
                candidates.add(a * b);
                
                // Subtraction (try both orders)
                candidates.add(a - b);
                candidates.add(b - a);
                
                // Division (try both orders, avoid division by zero)
                if (Math.abs(b) > EPS) {
                    candidates.add(a / b);
                }
                if (Math.abs(a) > EPS) {
                    candidates.add(b / a);
                }
                
                // For each result, recursively check with remaining numbers
                for (double candidate : candidates) {
                    List<Double> newNums = new ArrayList<>(remaining);
                    newNums.add(candidate);
                    if (backtrack(newNums)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
