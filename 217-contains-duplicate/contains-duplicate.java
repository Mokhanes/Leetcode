class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> count = new HashSet<>();

        for(int i : nums){
            if(count.contains(i)){
                return true;
            }else{
                count.add(i);
            }
        }

        return false;
    
    }
}