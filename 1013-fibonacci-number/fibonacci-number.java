class Solution {
    public int fib(int n) {
        // if(n<=1) return n;
        // return fib(n-1) + fib(n-2);

        int first = 0;
        int second = 1;
        int third = 1;

        if(n<=1) return n;
        else{
            for(int i = 2; i<=n; i++){
                third = first + second;
                first = second;
                second = third;
            }

            return third;
        }

        
    }
}