// Date: 23rd July 2025
// Day: Wednesday
public class Day36 {

    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removePattern(s, "ab", x, y);
        } else {
            return removePattern(s, "ba", y, x);
        }
    }

    private int removePattern(String s, String firstPattern, int firstScore, int secondScore) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        // Step 1: remove firstPattern (either "ab" or "ba")
        char first = firstPattern.charAt(0);
        char second = firstPattern.charAt(1);

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                score += firstScore;
            } else {
                stack.push(c);
            }
        }

        // Reconstruct string after first removal
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // Step 2: remove secondPattern (opposite of firstPattern)
        stack.clear();
        for (char c : sb.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && c == first) {
                stack.pop();
                score += secondScore;
            } else {
                stack.push(c);
            }
        }

        return score;
    }
}


