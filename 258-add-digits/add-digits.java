class Solution {
    public int addDigits(int num) {
        
        int n = num;
        while(num>9){
            n= num;
            int sum = 0;
            while(n!=0){
                sum+=n%10;
                n/=10;
            }
            num = sum;
        }

        return num;
    }
}