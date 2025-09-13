class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        //int arr[] = new int[26];
        int count = 0;
        for(int i = 0;i < stones.length();i++){
            char ch = stones.charAt(i);
            if(jewels.contains(""+ch))
                count++;
        }
        return count;
    }
}