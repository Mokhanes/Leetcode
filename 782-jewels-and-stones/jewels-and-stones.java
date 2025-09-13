class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        //int arr[] = new int[26];
        // int count = 0;
        // for(int i = 0;i < stones.length();i++){
        //     char ch = stones.charAt(i);
        //     if(jewels.contains(""+ch))
        //         count++;
        // }
        // return count;

        int i,count=0,j;
      for(i=0;i<jewels.length();i++)
        for(j=0;j<stones.length();j++)
            if(jewels.charAt(i)==stones.charAt(j))
                count++;
       
      return count;
    }
}