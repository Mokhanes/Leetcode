import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        
        Map<Integer, Integer> count = new HashMap<>();
        
        TreeMap<Integer, Integer> line = new TreeMap<>();
        
        Set<Integer> candidates = new TreeSet<>();

        for (int v : nums) {
            count.merge(v, 1, Integer::sum);
            int start = v - k;
            int end   = v + k + 1;
            line.merge(start, 1, Integer::sum);
            line.merge(end,   -1, Integer::sum);
            candidates.add(v);
            candidates.add(start);
            candidates.add(end);
        }

        int adjustable = 0;
        int ans = 1;

        for (int x : candidates) {
            adjustable += line.getOrDefault(x, 0);
            int cntX = count.getOrDefault(x, 0);
            int canAdjust = adjustable - cntX;       
            int useOps    = Math.min(numOperations, canAdjust);
            ans = Math.max(ans, cntX + useOps);
        }

        return ans;
    }
}
