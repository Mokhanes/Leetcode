class NumArray {

    private int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        sum[0] = 0;
        for(int i =1;i<=n;i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */