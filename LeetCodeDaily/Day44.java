//Date: 31th July 2025
// Day: Thursday

import java.util.HashSet;
import java.util.Set;
public class Day44 {
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A1 = {1, 2, 4};
        System.out.println(sol.subarrayBitwiseORs(A1)); // expected 6
    
        int[] A2 = {0};
        System.out.println(sol.subarrayBitwiseORs(A2)); // expected 1
    
        int[] A3 = {1, 1, 2};
        System.out.println(sol.subarrayBitwiseORs(A3)); // example: distinct ORs are {1,2,3} -> 3
    }
}

public class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        
        for (int x : A) {
            Set<Integer> curr = new HashSet<>();
            curr.add(x); // subarray consisting of x alone
            for (int v : prev) {
                curr.add(v | x);
            }
            result.addAll(curr);
            prev = curr;
        }
        
        return result.size();
    }

    // For quick testing
}
