class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char c : n.toCharArray()) {
            int digit = c - '0';
            maxDigit = Math.max(maxDigit, digit);
            if (maxDigit == 9) return 9; // early stop (since max digit possible)
        }
        return maxDigit;
    }
}
