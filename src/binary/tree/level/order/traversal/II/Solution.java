package binary.tree.level.order.traversal.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yebingxu on 6/3/15.
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {

    private static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    private static int max = -1;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        coreFunc(root, 0);
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        for (int i = max; i >= 0; i--) {
            List<Integer> valueList = map.get(i);
            retList.add(valueList);
        }
        return retList;
    }

    private void coreFunc(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if (max < level) {
            max = level;
        }

        List<Integer> valueList = map.get(level);
        if (valueList == null) {
            valueList = new ArrayList<Integer>();
            map.put(level, valueList);
        }
        valueList.add(root.val);
        coreFunc(root.left, level+1);
        coreFunc(root.right, level+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;

       List<List<Integer>> ret = s.levelOrderBottom(root);
    }
}

