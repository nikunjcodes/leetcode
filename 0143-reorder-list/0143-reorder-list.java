public class Solution{
public void reorderList(ListNode head) {
            if(head==null||head.next==null) return;
            ListNode temp1=head;
            ListNode temp2=head;
            while(temp2.next!=null&&temp2.next.next!=null){ 
                temp1=temp1.next;
                temp2=temp2.next.next;
            }
            ListNode middle=temp1;
            ListNode curr=temp1.next;
            while(curr.next!=null){
                ListNode current=curr.next;
                curr.next=current.next;
                current.next=middle.next;
                middle.next=current;
            }
            temp1=head;
            temp2=middle.next;
            while(temp1!=middle){
                middle.next=temp2.next;
                temp2.next=temp1.next;
                temp1.next=temp2;
                temp1=temp2.next;
                temp2=middle.next;
            }
        }
}