// class Solution {
//     public int[] recoverOrder(int[] order, int[] friends) {
//         int res[] = new int[friends.length];
//         int ind = 0;
//         for(int i =0;i<order.length;i++){
//             for(int j = 0;j<friends.length;j++){
//                 if(friends[j] == order[i]){
//                     res[ind++] = order[i];
//                 }
//             }
//         }

//         return res;
//     }
// }


class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        int m = friends.length;
        int[] res = new int[m];
        Set<Integer> friendsSet = new HashSet<>();
        for (int f : friends) {
            friendsSet.add(f);
        }
        int idx = 0; 
        for (int i = 0; i < n; i++) {
            if (friendsSet.contains(order[i])) {
                res[idx++] = order[i];
            }
        }

        return res;
    }
}