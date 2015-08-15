package balanced.binary.tree;

/**
 * Created by yebingxu on 7/22/15.
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {

        IntObj rheight = new IntObj(0);
        return isBalancedCore(root, rheight);
    }

    private boolean isBalancedCore(TreeNode root, IntObj height) {
        if (root == null) {
            height.val = 0;
            return true;
        }
        IntObj lh = new IntObj(0), rh = new IntObj(0);
        boolean lbool = isBalancedCore(root.left, lh);
        boolean rbool = isBalancedCore(root.right, rh);
        if (lbool && rbool && Math.abs(lh.val - rh.val) <= 1) {
            height.val = lh.val > rh.val ? lh.val + 1 : rh.val + 1;
            return true;
        } else {
            height.val = -1;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode r1 = new TreeNode(2);
        root.right = r1;
        r1.left = null;
        TreeNode r2 = new TreeNode(3);
        r1.right = r2;

        System.out.println(s.isBalanced(root));
    }
}

class IntObj {
    int val;
    IntObj(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}