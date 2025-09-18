class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        List<Integer> li = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entery : map.entrySet()){
            if(entery.getValue() == 2){
                li.add(entery.getKey());
            }
        }

        int res[] = new int[li.size()];
        int i = 0;
        for(int num : li)
            res[i++] = num;

        return res; 
    }
}