class Solution {
    public int smallestEvenMultiple(int n) {
        int i = 1;
        while(true){
            int num = n*i;
            if((num&1)==0)
                return num;
            i++;
        }
    }
}