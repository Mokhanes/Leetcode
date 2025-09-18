class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            sum += (i+1)*(('z' - ch) + 1);
        }
        return sum;
    }
}