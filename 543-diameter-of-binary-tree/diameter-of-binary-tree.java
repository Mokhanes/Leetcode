class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        // Update diameter: longest path through this node
        diameter = Math.max(diameter, left + right);

        // Return height of the tree
        return 1 + Math.max(left, right);
    }
}
