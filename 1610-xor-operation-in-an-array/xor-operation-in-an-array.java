class Solution {
    public int xorOperation(int n, int start) {
        int xor = start;
        int i = 1;
        start += 2;
        while(i<n){
            xor ^= start;
            i++;
            start+=2;
        }

        return xor;
    }
}