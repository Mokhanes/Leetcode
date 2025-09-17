class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int r=sum%k;
        if(r==0)return 0;
        return r;
        
    }
}