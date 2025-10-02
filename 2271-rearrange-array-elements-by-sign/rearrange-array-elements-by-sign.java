class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int pIndex = 0, nIndex = 1;
        for(int i =0;i<n;i++){
            if(nums[i] < 0){
                res[nIndex] = nums[i];
                nIndex+=2;
            }else{
                res[pIndex] = nums[i];
                pIndex+=2;
            }
        } 
        return res;
    }
}