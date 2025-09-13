public class Solution {
    public static int maxFreqSum(String s) {
        int[] freq = new int[26];  // frequency for each letter
        int maxVowel = 0, maxConsonant = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch < 'a' || ch > 'z') continue; // skip non-letters

            int idx = ch - 'a';
            freq[idx]++;

            if (isVowel(ch)) {
                if (freq[idx] > maxVowel) maxVowel = freq[idx];
            } else {
                if (freq[idx] > maxConsonant) maxConsonant = freq[idx];
            }
        }

        return maxVowel + maxConsonant;
    }

    private static boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
