class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sp = new HashMap<>();

         for(int i =0 ;i < nums.length ; i++ ){

              if(sp.containsKey(target - nums[i])){
                 return new int[]{sp.get(target - nums[i]),i};
             } else {
                sp.put(nums[i],i);
               }

         }

         return new int[]{};
    }
}