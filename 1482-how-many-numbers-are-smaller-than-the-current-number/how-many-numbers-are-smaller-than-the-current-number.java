// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int n = nums.length;
//         int res[] = new int[n];

//         for(int i =0;i<n;i++){
//             int c = 0;
//             for(int j =0;j<n;j++){
//                 if(nums[i] > nums[j]){
//                     c++;
//                 }
//             }
//             res[i] = c;
//         }

//         return res;
//     }
// }


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] freq = new int[101];
        for (int el : nums) {
            freq[el]++;
        }

        
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i - 1] + freq[i];
        }

        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
           ans[i] = nums[i] == 0 ? 0 : freq[nums[i] - 1];
        }

        return ans;
    }
}