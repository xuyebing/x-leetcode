package populating.next.right.pointers.in.each.node;

import apple.laf.JRSUIUtils;

import java.util.List;

/**
 * Created by yebingxu on 7/23/15.
 */
public class Solution {

    private TreeLinkNode rootSaved;
    public void connect(TreeLinkNode root) {
        rootSaved = root;
        StringBuilder pathSb = new StringBuilder("");
        connectCore(root, pathSb);
    }

    private void connectCore(TreeLinkNode root, StringBuilder pathSb) {
        if (root == null) {
            return;
        } else {
            connectCore(root.left, pathSb.append("0"));
            pathSb.deleteCharAt(pathSb.length()-1);
            connectCore(root.right, pathSb.append("1"));
            pathSb.deleteCharAt(pathSb.length()-1);

            int last0Idx = pathSb.lastIndexOf("0");
            if (last0Idx == -1) {
                // this node's next pointer points to null
                root.next = null;
            } else {
                char[] findPath = generatePath(pathSb.toString(), last0Idx);
                root.next = findNextNode(findPath);
            }
        }
    }

    private char[] generatePath(String path, int last0Idx){
        if (path == null) {
            return new char[0];
        }
        StringBuilder sb = new StringBuilder(path.substring(0, last0Idx));
        for (int i = last0Idx; i < path.length(); i++) {
            if (i == last0Idx) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString().toCharArray();
    }

    private TreeLinkNode findNextNode(char[] findPath) {
        TreeLinkNode retNode = this.rootSaved;
        for (int i = 0; i < findPath.length; i++) {
            if (findPath[i] == '0') {
                retNode = retNode.left;
            } else {
                retNode = retNode.right;
            }
        }
        return retNode;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int val) {
        this.val = val;
    }
}
