class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start  = 0;
        int end = 0;
        int maxLength = 0;

        boolean[] vist = new boolean[128];
        while(end<s.length()){
            char c = s.charAt(end);

            while(vist[c]){
                vist[s.charAt(start)] = false;
                start++;
            }

            vist[c] = true;

            maxLength = Math.max(end-start+1,maxLength);
            end++;
            
        } 
        // Set<Character> seen = new HashSet<>();

        // while(end<s.length()){
        //     char c = s.charAt(end);

        //     while(seen.contains(c)){
        //         seen.remove(s.charAt(start));
        //         start++;
        //     }

        //     seen.add(c);

        //     maxLength = Math.max(end-start+1,maxLength);
        //     end++;
        // }

        return maxLength;
    }
}