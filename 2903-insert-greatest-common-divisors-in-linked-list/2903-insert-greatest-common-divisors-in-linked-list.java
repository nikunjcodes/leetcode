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
    // Optimized GCD using the Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int gcd = gcd(curr.val, curr.next.val);
            ListNode temp = new ListNode(gcd, curr.next);
            curr.next = temp;
            curr = temp.next;
        }
        
        return head;
    }
}
