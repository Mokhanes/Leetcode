class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] parts = text.split(" ");
        char b[] = brokenLetters.toCharArray();
        int count = 0;
        for(String s : parts){
            boolean flag = true;
            for(char c : b){
                if(s.contains(""+c)){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        } 

        return count;
    }
}