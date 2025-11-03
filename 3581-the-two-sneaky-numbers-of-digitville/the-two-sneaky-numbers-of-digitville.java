class Solution {
    public int[] getSneakyNumbers(int[] a) 
    {
        int[] freq=new int[101];
        Arrays.fill(freq,0);
        for(int i:a)
            freq[i]++;
        int[] ans=new int[2];
        int ctr=0;
        for(int i=0;i<=100;i++)
        {
            if(freq[i]==2)
            {
                ans[ctr++]=i;
            }
        }    
        return ans;
    }
}