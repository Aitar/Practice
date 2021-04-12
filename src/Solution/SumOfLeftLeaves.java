package Solution;

import Entity.TreeNode;

public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        perOrder(root, false);
        return sum;
    }

    private void perOrder(TreeNode root, boolean left) {
        if(root == null) return;
        if(left && root.left == null && root.right == null)
            sum += root.val;
        perOrder(root.left, true);
        perOrder(root.right, false);
    }
}
