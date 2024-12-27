/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n + 1; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return head; // If n is larger than the length of the list, do nothing
            }
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode removed = slow.next;
        if (removed != null) {
            slow.next = removed.next;
        }

        return dummy.next;
    }
}