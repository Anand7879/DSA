// Date 21th june 2025
// Day Saturday

// You are given a string word and an integer k.
// We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
// Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.
// Return the minimum number of characters you need to delete to make word k-special.

// Example 1:
// Input: word = "aabcaba", k = 0
// Output: 3
// Explanation: We can make word 0-special by deleting 2 occurrences of "a" and 1 occurrence of "c". Therefore, word becomes equal to "baba" where freq('a') == freq('b') == 2.

import java.util.HashMap;

public class Day4 {
     public static void main(String[] args) {
        
        String word = "aabcaba";
         int k = 0;

    //    String word = "dabdcbdcdcd";
    //      int k = 2;

        //  int n = word.length();
        // int[] count = new int[26];
        // for (char c : word.toCharArray())
        //     count[c - 'a']++;

        //     for (int i : count) {
        //         System.out.println(i);
        //     }
        
        // int ans = n;
        // for (int minFreq : count) {
        //     if (minFreq == 0) continue;  // skip letters that don't appear
        //     int deletions = 0;
        //     for (int freq : count) {
        //         if (freq < minFreq) deletions += freq;
        //         else if (freq > minFreq + k) deletions += freq - (minFreq + k);
        //     }
        //     ans = Math.min(ans, deletions);
        // }
    
        // System.out.println(ans);


        // String str1 = "";
        // for (char ch : freqMap.keySet()) {
        //     str1+=ch;
        // }

        // System.out.println(str1);


         HashMap<Character,Integer> freqMap = new HashMap<>();

         for (char ch : word.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

         System.out.println(freqMap);

        
        int result = word.length();
        for (char ch: freqMap.keySet()) {
            int x = freqMap.get(ch);
            int deletion = 0;

            for (char c : freqMap.keySet()) {
                if (c == ch) continue;

                int freq = freqMap.get(c);

                if (freq > x + k) {
                    deletion += freq - (x + k);
                } else if (freq < x ) {
                    deletion += freq;
                }
            }

            result = Math.min(result, deletion);
        }
         
        System.out.println(result);
     }     
    
}
