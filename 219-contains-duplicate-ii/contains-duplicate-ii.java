class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j] && Math.abs(i-j)<=k)
        //             return true;
        //     }
        // }
        
        // for(int i =0;i<(nums.length-k);i++){
        //     if(nums[i]==nums[i+k])
        //         return true;
        // }
        // return false;

        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;  // duplicate found within window
            }
            window.add(nums[i]);
            
            // keep window size ≤ k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}