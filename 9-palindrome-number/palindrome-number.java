class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        int rn=0;
        while(n>0){
            int r=n%10;
            rn=(rn*10)+r;
            n=n/10;
        }
        if(x==rn){
            return true;
        }else{
            return false;
        }
    }
}