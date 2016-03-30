package unique.binary.search.trees.II;

/**
 * Created by yebingxu on 8/15/15.
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return toStringCore(this);
    }

    private String toStringCore(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null) {
            sb.append("," + root.val + "->l #");
        } else {
            sb.append(", " + toStringCore(root.left));
        }
        if (root.right == null) {
            sb.append(", " + root.val + "->r #");
        } else {
            sb.append(", " + toStringCore(root.right));
        }
        return sb.toString();
    }
}

public class Solution {

    private Map<String, List<TreeNode>> storeMap = new HashMap<String, List<TreeNode>>();

    private String getKey(int i, int beginFrom) {
        String key = "" + (i-1) + "-" + beginFrom;
        return key;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            TreeNode root = null;
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(root);
            return list;
        }
        return generateTrees(n, 0);
    }

    public List<TreeNode> generateTrees(int n, int beginFrom) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        String key0 = getKey(n, beginFrom);
        if (storeMap.containsKey(key0)) {
            return storeMap.get(key0);
        }


        List<TreeNode> retList = new ArrayList<TreeNode>();
        for (int i = 1; i <= n; i++) {

            List<TreeNode> leftList = null;
            String key = getKey(i-1, beginFrom);
            if (storeMap.containsKey(key)) {
                leftList = storeMap.get(key);
            } else {
                leftList = generateTrees(i - 1, beginFrom);
                storeMap.put(key, leftList);
            }
            List<TreeNode> rightList = null;
            String key2 = getKey(n-i, beginFrom+i);
            if (storeMap.containsKey(key2)) {
                rightList = storeMap.get(key2);
            } else {
                rightList = generateTrees(n - i, beginFrom + i);
                storeMap.put(key2, rightList);
            }

            if (leftList.size() == 0) {
                if (rightList.size() == 0) {
                    TreeNode rootNode = new TreeNode(beginFrom + i);
                    retList.add(rootNode);
                } else {
                    for (int j = 0; j < rightList.size(); j++) {
                        TreeNode rootNode = new TreeNode(beginFrom + i);
                        rootNode.right = rightList.get(j);

                        retList.add(rootNode);
                    }
                }
            } else {
                for (int k = 0; k < leftList.size(); k++) {
                    if (rightList.size() == 0) {
                        TreeNode rootNode = new TreeNode(beginFrom + i);
                        rootNode.left = leftList.get(k);
                        retList.add(rootNode);
                    } else {
                        for (int j = 0; j < rightList.size(); j++) {
                            TreeNode rootNode = new TreeNode(beginFrom + i);
                            rootNode.left = leftList.get(k);
                            rootNode.right = rightList.get(j);

                            retList.add(rootNode);
                        }
                    }
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<TreeNode> lists = s.generateTrees(4);
//        List<TreeNode> lists = s.generateTrees(2,2);

        System.out.println("lists.size: " + lists.size());
        for (int i = 1; i <= lists.size(); i++) {
            System.out.println(i + " : " + lists.get(i-1));
        }
    }
}
