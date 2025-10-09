// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n = nums.length;
//         if(n==0) return 0;

//         int l = 1;

//         Set<Integer> set = new HashSet<>();

//         for(int val : nums) set.add(val);

//         for(int val : set){
//             if(!set.contains(val-1)){
//                 int c = 1;
//                 int x = val;
//                 while(set.contains(x + 1)){
//                     x++;
//                     c++;
//                 }

//                 l = l < c? c : l;
//             }
//         }

//         return l;
//     }
// }


import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);  // O(n log n)

        int longest = 1;
        int currentStreak = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]) { // skip duplicates
                if(nums[i] == nums[i-1] + 1){
                    currentStreak++;
                } else {
                    currentStreak = 1;
                }
                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}