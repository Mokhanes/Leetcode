class Solution {
    public int nextBeautifulNumber(int n) {
        for (int num = n + 1; ; num++) {
            if (isBalanced(num)) return num;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        int temp = num;
        if (temp == 0) return false; 

        while (temp > 0) {
            count[temp % 10]++;
            temp /= 10;
        }

        if (count[0] > 0) return false;

        
        for (int d = 1; d <= 9; d++) {
            if (count[d] != 0 && count[d] != d) return false;
        }
        return true;
    }
}
