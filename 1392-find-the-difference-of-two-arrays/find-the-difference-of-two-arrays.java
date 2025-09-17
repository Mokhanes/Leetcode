import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        
        Set<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);
        
        Set<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(diff1));
        res.add(new ArrayList<>(diff2));
        
        return res;
    }
}
