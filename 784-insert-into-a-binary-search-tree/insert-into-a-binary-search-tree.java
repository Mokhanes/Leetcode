/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root == null)
    //         return new TreeNode(val);

    //     if(root.val < val)
    //         root.right = insertIntoBST(root.right,val);
    //     else
    //         root.left = insertIntoBST(root.left,val);
        
    //     return root;
    // }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode cur = root;
        while(cur!=null){
            if(cur.val < val){
                if(cur.right == null){
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }else{
                if(cur.left == null){
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
        }

        return root;
        
    }
}