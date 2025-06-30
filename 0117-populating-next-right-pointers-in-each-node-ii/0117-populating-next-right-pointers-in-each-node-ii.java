/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
       Node nxt = null;
       while(!q.isEmpty()){
        int size= q.size();
        for(int i=0 ; i<size ; i++){
            Node temp = q.poll();
            temp.next = nxt;
            nxt = temp;
            if(temp.right!=null)
                q.add(temp.right);
            if(temp.left!=null)
                q.add(temp.left);
            }
        nxt =null;
       }
       return root;

    }
}