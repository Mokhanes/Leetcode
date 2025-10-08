// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> res = new ArrayList<>();

//         for(int i =0;i<nums.length;i++){
//             int ind = Math.abs(nums[i]) - 1;
//             if(nums[ind] > 0){
//                 nums[ind] = -nums[ind];
//             }
//         }

//         for(int i =0;i<nums.length;i++){
//             if(nums[i] > 0) res.add(i+1);
//         }

//         return res;
//     }
// }


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       int len = nums.length;

       boolean[] map = new boolean[len+1];

        for (int i=0;i<len;i++) {
            map[nums[i]] = true;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i=1;i<=len;i++) {
            if (!map[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}