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
    public ListNode reverseKGroup(ListNode head, int k) {
        int kval =0;
        ListNode temp = head;
        while(temp!=null && kval!=k){
            temp = temp.next;
            kval++;
        }
        if(kval ==k){
            temp = reverseKGroup(temp  , k);
            while(kval --  >0){
                ListNode node = head.next;
                head.next = temp;
                temp = head;
                head = node; 
            }
            head = temp;
        }
        return head;
    }
}