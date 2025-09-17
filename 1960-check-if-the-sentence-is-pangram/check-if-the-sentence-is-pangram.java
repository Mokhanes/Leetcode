class Solution {
    public boolean checkIfPangram(String s) {
        // Set<Character> set = new HashSet<>();
        // for(int i =0;i<sentence.length();i++){
        //     set.add(sentence.charAt(i));
        // }

        // return set.size() == 26;

        if(s.length() < 26) return false;

        for(char c = 'a';c<='z';c++){
            if(s.indexOf(c) == -1) return false;
        }

        return true;
    }
}