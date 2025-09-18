class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int res[] = new int[friends.length];
        int ind = 0;
        for(int i =0;i<order.length;i++){
            for(int j = 0;j<friends.length;j++){
                if(friends[j] == order[i]){
                    res[ind++] = order[i];
                }
            }
        }

        return res;
    }
}