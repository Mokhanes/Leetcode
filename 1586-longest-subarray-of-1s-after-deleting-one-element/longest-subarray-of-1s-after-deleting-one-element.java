class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int lastZeroIdx = -1, prevLen = 0, currLen = 0;
        boolean foundZero = false;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currLen++;
            } else {
                foundZero = true;
                maxLen = Math.max(maxLen, prevLen + currLen);
                prevLen = currLen;
                currLen = 0;
            }
        }
        maxLen = Math.max(maxLen, prevLen + currLen);

        // If there's no zero, need to remove one element (as per problem statement)
        return foundZero ? maxLen : nums.length - 1;
    }
}
