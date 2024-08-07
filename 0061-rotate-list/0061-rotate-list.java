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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fast = temp;
        ListNode tem = temp;
        int i=0;
        while(fast.next!=null){
            fast = fast.next;
            i++;
        }
        int pos = i-k%i;
        for(int j=pos ; j>0 ; j--){
            tem=tem.next;
        }
        fast.next = temp.next;
        temp.next = tem.next;
        tem.next = null;
        return temp.next;
                                                                                            
    }
}