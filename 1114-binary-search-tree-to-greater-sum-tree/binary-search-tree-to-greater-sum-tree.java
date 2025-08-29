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
    int greater = 0;
    public TreeNode bstToGst(TreeNode root) {
        
        if(root == null) return null;

        bstToGst(root.right);
        greater += root.val;
        root.val = greater;
        bstToGst(root.left);

        return root;
    }

}