package binary.tree.max.path.sum;

/**
 * Created by yebingxu on 8/22/15.
 */

class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Flag {
    boolean isValid;
    public Flag(boolean valid) {
        isValid = valid;
    }
}

public class Solution {
    private int max = Integer.MIN_VALUE;
    private Flag maxValid = new Flag(false);
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Flag lValid = new Flag(true);
        Flag rValid = new Flag(true);
        int lSum = maxPathSumCore(root.left, lValid);
        int rSum = maxPathSumCore(root.right, rValid);
        max = findMax(lSum, lValid, rSum, rValid, max, root.val); // set max to the bigger one of lSum and rSum, it may be overwrite by other bigger number

        return max;
    }

    private int findMax(int lSum, Flag lValid, int rSum, Flag rValid, int max, int rootVal) {
        int retMax = max;
        if (lValid.isValid) {
            retMax = Math.max(retMax, lSum);
            maxValid.isValid = true;
        }
        if (rValid.isValid) {
            retMax = Math.max(retMax, rSum);
            maxValid.isValid = true;
        }

        if (maxValid.isValid) {
            retMax = Math.max(retMax, retMax+rootVal);
            retMax = Math.max(retMax, rootVal);
        } else {
            retMax = rootVal;
            maxValid.isValid = true;
        }

        return retMax;
    }

    private int maxPathSumCore(TreeNode root, Flag valid) {
        if (root == null) {
            valid.isValid = false;
            return 0;
        }
        Flag lValid = new Flag(true);
        Flag rValid = new Flag(true);
        int lSum = maxPathSumCore(root.left, lValid);
        int rSum = maxPathSumCore(root.right, rValid);
        max = findMax(lSum, lValid, rSum, rValid, max, root.val); // set max to the bigger one of lSum and rSum, it may be overwrite by other bigger number

        int lPlusRoot = root.val;
        if (lValid.isValid) {
            lPlusRoot = lSum + root.val;
        }
        int rPlusRoot = root.val;
        if (rValid.isValid) {
            rPlusRoot = rSum + root.val;
        }

        return Math.max(lPlusRoot, rPlusRoot);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(-3);
        s.maxPathSum(root);
    }
}
