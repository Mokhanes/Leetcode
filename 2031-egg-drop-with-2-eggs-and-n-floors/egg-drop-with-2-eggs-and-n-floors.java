class Solution {
    public int twoEggDrop(int n) {
        return (int) Math.ceil((-1 + Math.sqrt(1 + 8.0 * n)) / 2.0);
    }
}