//Date 15th july 2025
// Day Tuesday

public class Day28 {
    public static void main(String[] args) {

        String[] tests = {
            "234Adas", // true
            "b3",      // false (too short, no vowel)
            "a3$e",    // false (invalid char, no consonant)
            "Ae1",     // true
            "123",     // false (no letters)
            "bcde",    // false (no vowel)
        };

        for (String t : tests) {
            System.out.printf("\"%s\" → %b%n", t, isValid(t));
        }
    }

    public static boolean isValid(String word) {
        if (word == null || word.length() < 3) return false;

        boolean hasVowel = false, hasConsonant = false;
        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;

            if (Character.isLetter(ch)) {
                char c = Character.toLowerCase(ch);
                if ("aeiou".indexOf(c) != -1) hasVowel = true;
                else hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }

   
}

