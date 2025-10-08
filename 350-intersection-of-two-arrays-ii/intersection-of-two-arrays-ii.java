class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums1) map.put(num,map.getOrDefault(num,0)+1);

        List<Integer> res = new ArrayList<>();

        for(int n : nums2){
            if(map.containsKey(n) && map.get(n)!=0){
                res.add(n);
                map.put(n,map.get(n)-1);
            }
        }

        int r[] = new int[res.size()];

        int i =0;
        for(int n : res) r[i++] = n;

        return r;
    }
}