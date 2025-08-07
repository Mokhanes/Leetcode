class Solution {
    public int firstUniqChar(String s) {
        int l = s.length();

        if(l==1)
            return 0;

        for(int i =0;i<l;i++){
            boolean flag = true;
            for(int j = 0;j<l;j++){
                if(s.charAt(i)==s.charAt(j) && i!=j){
                    flag = false;
                    break;
                }
            }

            if(flag){
                return i;
            }
        }

        return -1;
    }
}