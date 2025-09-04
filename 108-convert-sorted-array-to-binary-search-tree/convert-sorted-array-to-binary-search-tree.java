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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        return getBST(nums, 0, nums.length-1);
    }

    public TreeNode getBST(int nums[], int start, int end){
        if(start>end) return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = getBST(nums, start, mid-1);
        node.right = getBST(nums, mid+1, end);

        return node;

    }
}