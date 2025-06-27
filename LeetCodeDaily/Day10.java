// Date 27th june 2025
// Day friday

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Day10 {
    public static void main(String[] args) {
        
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Filter characters that appear at least k times
        List<Character> validChars = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (freq.getOrDefault(c, 0) >= k) {
                validChars.add(c);
            }
        }

        // Sort in reverse lex order (for lexicographically largest first)
        validChars.sort(Collections.reverseOrder());

        Queue<String> queue = new LinkedList<>();
        for (char c : validChars) {
            queue.offer("" + c);
        }

        String ans = "";

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (isKRepeatedSubsequence(s, cur, k)) {
                if (cur.length() > ans.length() || 
                   (cur.length() == ans.length() && cur.compareTo(ans) > 0)) {
                    ans = cur;
                }
                // Only extend if current is valid
                if (cur.length() < 7) {
                    for (char c : validChars) {
                        queue.offer(cur + c);
                    }
                }
            }
        }

        return ans;
    }

    private boolean isKRepeatedSubsequence(String s, String sub, int k) {
        String repeated = sub.repeat(k);
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < repeated.length() && c == repeated.charAt(i)) {
                i++;
            }
        }
        return i == repeated.length();
    }
    
}
