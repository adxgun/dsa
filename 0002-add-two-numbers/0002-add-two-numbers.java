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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2 4 3 
        // 5 6 4 
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        int total = 0, carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            // total = 2 -> total = 4 -> total = 4
            // l1.next.val = 4 -> l1.next.val = 3 -> l1.next = null;

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            // total = 7 -> total = 10 -> total = 8
            // l2.next.val = 6 -> l2.next.val = 4 -> l2.next.val = null

            int num = total % 10; // 7 % 10 = 7 -> 10 % 10 = 0 -> 8 % 10 = 0
            carry = total / 10; // 7 / 10 = 0.7 => int(0) -> 10 / 10 = 1 -> 8/10 -> 0.8 -> int(0)
            dummy.next = new ListNode(num); // dummy.next = 7 -> dummy.next = 0 -> dummy.next = 0
            dummy = dummy.next; // dummy = [val=7,next=null] -> dummy = [val=0,next=null] -> dummy = [val=0,next=null]
        }
        return result.next;
    }
}