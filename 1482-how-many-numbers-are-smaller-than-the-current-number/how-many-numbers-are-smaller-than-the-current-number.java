class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        for(int i =0;i<n;i++){
            int c = 0;
            for(int j =0;j<n;j++){
                if(nums[i] > nums[j]){
                    c++;
                }
            }
            res[i] = c;
        }

        return res;
    }
}