package swap.nodes.in.pairs;

/**
 * Given a linked list, swap every II adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 * @author yebingxu
 *
 */

public class Solution {

    class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
    public ListNode swapPairs(ListNode head) {
        if (head == null)
        	return head;
        ListNode p = head;
        ListNode q = p.next;
        ListNode r = null;
        ListNode newHead = head;
        while (q != null) {
        	if (r == null) {
        		p.next = q.next;
        		q.next = p;
        		newHead = q;
        	} else {
        		p.next = q.next;
        		q.next = p;
        		r.next = q;
        	}
        	r = p;
        	p = p.next;
        	if (p != null)
        		q = p.next;
        	else
        		q = null;
        }
        return newHead;
    }
}
