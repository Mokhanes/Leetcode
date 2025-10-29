class Solution {
    public int[] twoSum(int[] nums, int t) {
       int n = nums.length;
       int r[] = new int[2];
       for(int i =0;i<n;i++){
        for(int j =i+1;j<n;j++){
            if(nums[i] + nums[j] == t){
                r[0] = i;
                r[1] = j;
                return r;
            }
        }
       }

       return r;
    }
}