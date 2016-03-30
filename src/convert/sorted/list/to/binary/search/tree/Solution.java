package convert.sorted.list.to.binary.search.tree;

/**
 * Created by yebingxu on 8/22/15.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode p = head;
        while (p!=null) {
            len++;
            p=p.next;
        }

        return buildTree(head, len);
    }

    private TreeNode buildTree(ListNode head, int length) {
        if (length < 1) {
            return null;
        }

        if (length == 1) {
            TreeNode node = new TreeNode(head.val);
            node.left = null;
            node.right = null;
            return node;
        }
        int mid = length/2;
        ListNode p = head;
        int idx = mid;
        while(idx >= 1) { // mid means how much steps we need to move the pointer
            p = p.next;
            idx--;
        }
        TreeNode node = new TreeNode(p.val);
        node.left = buildTree(head, mid); // mid means the sublist length before ListNode p
        node.right = buildTree(p.next, length - mid - 1); // minus 1 means exclude the ListNode p

        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        /***/
        ListNode head = new ListNode(3);
        ListNode p2 = new ListNode(5);
        ListNode p3 = new ListNode(8);
        head.next = p2;
        p2.next = p3;

        s.sortedListToBST(head);
    }
}
