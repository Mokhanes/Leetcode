class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        int arr[] = new int[26];
        for(char c : allowed.toCharArray())
            arr[c - 97]++;
        
        for(String s : words){
            boolean flag = true;
            for(char ch : s.toCharArray()){
                if(arr[ch - 97] == 0 ){
                    flag = false;
                    break;
                }
            }
            if(flag)
                count++;
        }

        return count;
    }
}