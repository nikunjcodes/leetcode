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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }
    
    static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMid(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);
        return merge(left, right);
    }
    
    static ListNode merge(ListNode l, ListNode r) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        while(l!=null && r!=null){
            if(l.val <=r.val){
                current.next = l;
                l=l.next;
            }
            else{
                current.next = r;
                r=r.next;
            }
            current = current.next;
        }
        if(l!=null){
            current.next = l;
        }
        else if (r!=null)
            current.next = r;
        return temp.next;
    }
    
    static ListNode getMid(ListNode node) {
        if (node == null) {
            return node;
        }
        
        ListNode slow = node;
        ListNode fast = node.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
