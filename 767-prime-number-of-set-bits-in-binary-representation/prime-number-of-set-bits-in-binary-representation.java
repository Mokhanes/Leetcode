// class Solution {
//     private static final Set<Integer> PRIMES = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
    
//     public int countPrimeSetBits(int left, int right) {
//         int count = 0;
//         for (int num = left; num <= right; num++) {
//             int ones = Integer.bitCount(num);
//             if (PRIMES.contains(ones)) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ct = 0;
        for(int i = left; i <= right; i++){
            int c = Integer.bitCount(i);
            if(c == 2 || c == 3|| c==5||c==7||c==11||c==13||c==17||c==19){
            ct++;
            }
        }
    return ct;
}
}