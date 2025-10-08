class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i =0;i<nums.length;i++){
            int ind = Math.abs(nums[i]) - 1;
            if(nums[ind] > 0){
                nums[ind] = -nums[ind];
            }
        }

        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0) res.add(i+1);
        }

        return res;
    }
}