import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int rem = (int)(total % p);
        if (rem == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case
        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int curMod = (int)(prefix % p);

            // we want: prefix[j] % p == (curMod - rem + p) % p
            int need = (curMod - rem + p) % p;

            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            // store/update current prefix
            map.put(curMod, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
