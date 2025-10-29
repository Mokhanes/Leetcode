class Solution {
    public int smallestNumber(int n) {
        int count=0;
        while(n!=0){
            count++;
            n>>=1;
        }
        int res=1<<count;
        return res-1;
    }
}