class Solution {
    public boolean doesAliceWin(String s) {
        int len1 = s.length();
        s = s.replaceAll("[aeiouAEIOU]","");
        if(len1 == s.length())
            return false;
        return true;
    }
}