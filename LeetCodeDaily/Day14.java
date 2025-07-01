// Date 1st july 2025
// Day Tuesday

public class Day14 {
    public static void main(String[] args) {
        String word = "abbcccc";
        System.out.println(possibleStringCount(word));
    }
    
    public static int possibleStringCount(String word) {
        int ans = 1;  // count the "no long‑press" case
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ans++;
            }
        }
        return ans;
    }

}
