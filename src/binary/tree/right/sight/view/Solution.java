package binary.tree.right.sight.view;

/**
 * @author yebingxu
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 思路：深度优先遍历(Deep First Search, DFS)
    // 遍历的过程中根据当前层的深度，将所在节点保存到连接表中，采用后续遍历，
    // 最后，对每层找链表中最后的一个节点作为该层的代表返回

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }

        Map<Integer, List<Integer>> mem = new HashMap<Integer, List<Integer>>();

        postOrderTraversal(mem, root, 0);

        // 输出最后的结果
        int deep = mem.size(); // deep为二叉树的层深
        for (int i = 0; i < deep; i++) {
            List<Integer> values = mem.get(i); // 拿到第i层节点的所有值
            int val = values.get(values.size()-1); // values的最后一个值即为第i层最右侧的值
            results.add(val);
        }

        return results;
    }

    private void postOrderTraversal(Map<Integer, List<Integer>> mem, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postOrderTraversal(mem, root.left, level+1);
        }
        if (root.right != null) {
            postOrderTraversal(mem, root.right, level+1);
        }
        // add root into mem
        List<Integer> levelList = mem.computeIfAbsent(level, key -> new ArrayList<Integer>());
        levelList.add(root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        s.rightSideView(root);
    }
}
