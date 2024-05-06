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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
                return null;
        else if (list1==null)
                return list2;
        else if(list2==null)
                return list1;
        ListNode head = null;
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode curr = null;
        while(l1!=null && l2!=null){
            ListNode newN = new ListNode();
            if(l1.val <= l2.val){
                newN.val = l1.val;
                l1 = l1.next;
            }
            else{
                newN.val = l2.val;
                l2=l2.next;
            }
            if(head == null)
                head = newN;
            else
                curr.next = newN;
            curr = newN;
        }
        while(l1!=null){
            ListNode newN = new ListNode(l1.val);
            curr.next = newN;
            curr = newN;
            l1=l1.next;
            
        }
                while(l2!=null){
            ListNode newN = new ListNode(l2.val);
            curr.next = newN;
            curr = newN;
            l2=l2.next;
            
        }
        return head;
        
    }
}