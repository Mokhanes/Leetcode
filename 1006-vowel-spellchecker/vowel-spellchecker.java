import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));

        // Case-insensitive map
        Map<String, String> caseMap = new HashMap<>();
        // Vowel-error map
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            caseMap.putIfAbsent(word.toLowerCase(), word);
            vowelMap.putIfAbsent(devowel(word.toLowerCase()), word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (words.contains(query)) {
                result[i] = query;  // Exact match
            } else {
                String lower = query.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower);  // Case-insensitive match
                } else {
                    String dev = devowel(lower);
                    result[i] = vowelMap.getOrDefault(dev, ""); // Vowel-error match
                }
            }
        }

        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
