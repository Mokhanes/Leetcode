class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int week = 1;
        while(n>0){
            if(n>=7){
                sum += sumMoney(week,week+6);
                n-=7;
                week++;
            }else{
                sum += sumMoney(week,week+n-1);
                n = 0;
            }
        }

        return sum;
    }

    public static int sumMoney(int e, int s){
        return (int)(s*(s+1)/2) - (e*(e-1)/2);
    }
}