class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
      
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int prefix = 0;
        for (int i = 0; i < n; i++) {
            total -= nums[i];  
            if (nums[i] == 0) {
                int suffix = total;
                
                if (prefix == suffix) {
                    ans += 2;  
                } else if (Math.abs(prefix - suffix) == 1) {
                    ans += 1;  
                }
            }
            prefix += nums[i];
        }
        return ans;
    }
}
