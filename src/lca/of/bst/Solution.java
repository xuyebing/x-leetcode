package lca.of.bst;

/**
 * @author yebingxu
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = buildPath(root, p);
        List<TreeNode> path2 = buildPath(root, q);

        int size1 = path1.size();
        int size2 = path2.size();
        int len = size1 < size2 ? size1 : size2;
        int i = 0;
        for (; i < len; i++) {
            if (path1.get(i).val != path2.get(i).val) {
                break;
            }
        }
        if (i < len) {
            return path1.get(i);
        } else {
            if (size1 < size2) {
                return path1.get(size1-1);
            } else {
                return path2.get(size2-1);
            }
        }
    }

    private List<TreeNode> buildPath(TreeNode root, TreeNode t) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode troot = root;
        while (true) {
            path.add(troot);
            if (troot.val == t.val) {
                break;
            } else if (troot.val < t.val) {
                troot = troot.right;
            } else {
                troot = troot.left;
            }
        }
        return path;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.lowestCommonAncestor();
//    }
}