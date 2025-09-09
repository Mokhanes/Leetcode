class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] countS1 = new int[26];
        int[] countWindow = new int[26];

        // frequency of s1
        for (char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }

        // initial window
        for (int i = 0; i < n; i++) {
            countWindow[s2.charAt(i) - 'a']++;
        }

        if (matches(countS1, countWindow)) return true;

        // sliding window
        for (int i = n; i < m; i++) {
            countWindow[s2.charAt(i) - 'a']++;               // add new char
            countWindow[s2.charAt(i - n) - 'a']--;           // remove old char

            if (matches(countS1, countWindow)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}