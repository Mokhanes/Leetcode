import java.util.*;

class Solution {

    List<List<Integer>> allSubsets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return allSubsets;
    }

    private void backtrack(int[] nums, int index, List<Integer> current) {
        allSubsets.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            
            if (i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
