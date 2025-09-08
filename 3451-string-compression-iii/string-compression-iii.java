class Solution {
    // public String compressedString(String word) {
    //     int l = word.length();
    //     String res ="";
    //     int count  = 1;
    //     for(int i = 0;i < l; i++){
    //         if(i+1 < l && count < 9 && word.charAt(i) == word.charAt(i+1)){
    //             count++;
    //         }else{
    //             res = res + count + word.charAt(i);
    //             count = 1;
    //         }
    //     }

    //     return res;
    // }
    public String compressedString(String word) {
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;){
            char s=chars[i];            
            i++;
            int j=1;
            while(i<chars.length && chars[i]==s && j<9){
                j++;
                i++;
            }                          
            sb.append((char) (j + '0'));          
            sb.append(s);                    
        }        
        return sb.toString();
    }
}