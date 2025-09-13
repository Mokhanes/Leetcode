class Solution {
    public int balancedStringSplit(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append(s.charAt(0));
        for(int i =1;i<s.length();i++){
            char c = s.charAt(i);
            sb.append(c);
            if(chack(sb.toString())){
                count++;
                sb.setLength(0);
            }
            
        }
        return count;
    }

    public static boolean chack(String s){
        int l = 0;
        int r = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == 'R')
                r++;
            else
                l++;
        }

        return r == l;
    }
}