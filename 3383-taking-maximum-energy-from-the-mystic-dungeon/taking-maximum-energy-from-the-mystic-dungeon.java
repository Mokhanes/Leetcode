class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        
        for (int i = n - 1 - k; i >= 0; i--) {
            energy[i] += energy[i + k];
        }
        
        int max = Integer.MIN_VALUE;
        for (int val : energy) {
            max = Math.max(max, val);
        }
        
        return max;
    }
}
