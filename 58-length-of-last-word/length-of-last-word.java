class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        //String s2[] = s.split(" ");
        // int lastindex = s.lastIndexOf(" ");
        // return s.length() - lastindex - 1; 

        int count = 0;
        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' ') count++;
            else break;
        }

        return count;

    }
}