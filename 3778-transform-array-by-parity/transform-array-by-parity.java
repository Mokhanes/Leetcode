class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i]%2==0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i] > nums[j]){
                    nums[i] = 0;
                    nums[j] = 1;
                }
            }
        }

        return nums;
    }
}