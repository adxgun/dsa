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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len += 1;
            curr = curr.next;
        }

        System.out.println(len);

        int mid = len / 2;
        curr = head;
        for (int i = 0; i < mid - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }
}