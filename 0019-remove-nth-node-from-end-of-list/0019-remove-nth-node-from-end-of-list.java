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
        if (head == null) return null;

        // Create a dummy node to handle edge cases (like removing the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 1️⃣: Move fast n+1 steps ahead so that slow is just before the node to delete
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2️⃣: Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3️⃣: Delete the node after slow
        slow.next = slow.next.next;

        // Return the new head
        return dummy.next;
    }
}
