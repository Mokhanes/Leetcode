class Solution {
    public int maxProfit(int[] prices) {
        int byprices = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int p : prices){
            if(p < byprices) byprices = p;
            else{
                int profit = p - byprices;
                maxprofit = Math.max(profit,maxprofit);
            }
        }

        return maxprofit;
    }
}