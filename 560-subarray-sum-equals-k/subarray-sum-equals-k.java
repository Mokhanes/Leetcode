class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefix sum = 0 appears once

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // check if (sum - k) exists in map
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // store current prefix sum in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}