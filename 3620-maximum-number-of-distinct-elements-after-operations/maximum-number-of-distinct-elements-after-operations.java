import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinct = 0;
        long nextFree = Long.MIN_VALUE; 

        for (int x : nums) {
            long low = (long)x - k;
            long high = (long)x + k;

            
            long val = Math.max(low, nextFree);

            if (val <= high) {
                distinct++;
                nextFree = val + 1; 
            }
        }
        return distinct;
    }
}
