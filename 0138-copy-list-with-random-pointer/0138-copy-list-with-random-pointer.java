/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node temp = head;
        while(temp!=null){
            Node next = temp.next;
            Node copy = new Node(temp.val);
            copy.next = next;
            temp.next = copy;
            temp = next;
        }
        temp=head;
        while(temp!=null){
            Node copy = temp.next;
            if(temp.random!=null)
                copy.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        Node first = new Node(-1);
        Node ans = first;
        while(temp!=null){
            ans.next = temp.next;
            ans = ans.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return first.next;
    }
}