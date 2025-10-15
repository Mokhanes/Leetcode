class Solution {
    public int findComplement(int num) {
        int bits = Integer.toBinaryString(num).length();
        int mask = (1 << bits) - 1;
        return (~num) & mask;
    }
}