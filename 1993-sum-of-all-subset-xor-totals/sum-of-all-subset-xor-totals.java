class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int or = 0;
        for (int v : nums) or |= v;
        return or * (1 << (n - 1));
    }
}