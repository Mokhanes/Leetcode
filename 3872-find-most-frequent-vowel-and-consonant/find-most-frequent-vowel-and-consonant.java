import java.util.*;

public class Solution {
    public static int maxFreqSum(String s) {
        Map<Character, Integer> vowelMap = new HashMap<>();
        Map<Character, Integer> consonantMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (!Character.isLetter(ch)) continue; // skip non-letters

            if (isVowel(ch)) {
                vowelMap.put(ch, vowelMap.getOrDefault(ch, 0) + 1);
            } else {
                consonantMap.put(ch, consonantMap.getOrDefault(ch, 0) + 1);
            }
        }

        int maxVowelFreq = vowelMap.values().stream().max(Integer::compare).orElse(0);
        int maxConsonantFreq = consonantMap.values().stream().max(Integer::compare).orElse(0);

        return maxVowelFreq + maxConsonantFreq;
    }

    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    
}
