class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxW = 0;
        for(int i =0;i<accounts.length;i++){
            int curW = 0;
            for(int j =0;j<accounts[0].length;j++){
                curW += accounts[i][j];
            }

            maxW = Math.max(maxW,curW);
        }

        return maxW;
    }
}