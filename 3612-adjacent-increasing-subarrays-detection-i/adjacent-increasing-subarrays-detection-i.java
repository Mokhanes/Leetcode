class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prevLen = 0;
        int curLen = 0;
        int maxPossible = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            curLen++;
            
            if (i == n - 1 || nums.get(i) >= nums.get(i+1)) {
                
                maxPossible = Math.max(maxPossible, Math.max(curLen / 2, Math.min(prevLen, curLen)));
                
                prevLen = curLen;
                curLen = 0;
            }
        }
        return maxPossible >= k;
    }
}
