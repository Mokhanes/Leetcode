class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> count = new HashSet<>();

        for(int i : nums){
            if(!count.add(i))
                return true;
        }

        return false;
    
    }
}