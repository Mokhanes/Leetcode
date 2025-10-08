class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<Integer> inter = new HashSet<>(set1);
        inter.retainAll(set2);

        int res[] = new int[inter.size()];

        int i = 0;
        for(int num : inter) res[i++] = num;

        return res;


    }
}