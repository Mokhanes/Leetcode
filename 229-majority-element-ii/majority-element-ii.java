class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0;i<n;i++){
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (n / 3)) {
                res.add(it.getKey());
            }
        }

        return res;
    }
}