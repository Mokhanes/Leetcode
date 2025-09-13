class Solution {
        public int balancedStringSplit(String s) {
            int x = 0;
            int count = 0;
            int n = s.length();
            for(int i=0;i<n;i++)
            {
                char ch=s.charAt(i);
                if(ch == 'L') x++;
                if(ch == 'R') x--;
                if(x==0) count++;
            }
            return count;

        }

    // public int balancedStringSplit(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     int count = 0;
    //     sb.append(s.charAt(0));
    //     for(int i =1;i<s.length();i++){
    //         char c = s.charAt(i);
    //         sb.append(c);
    //         if(chack(sb.toString())){
    //             count++;
    //             sb.setLength(0);
    //         }
            
    //     }
    //     return count;
    // }

    // public static boolean chack(String s){
    //     int l = 0;
    //     int r = 0;
    //     for(int i =0;i<s.length();i++){
    //         if(s.charAt(i) == 'R')
    //             r++;
    //         else
    //             l++;
    //     }

    //     return r == l;
    // }
}