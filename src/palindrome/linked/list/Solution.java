package palindrome.linked.list;

/**
 * Created by yebingxu on 8/15/15.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len < 2) {
            return true;
        }
        int mid = len/ 2;
        p = head;
        ListNode q = null;
        while (mid > 0) {
            ListNode r = p.next;
            p.next = q;
            q = p;
            p = r;
            mid--;
        }
        if ((len % 2) != 0 ) {
            p = p.next;
        }
        while (p != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;

    }
}
