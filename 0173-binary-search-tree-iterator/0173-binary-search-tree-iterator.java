/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {

        while(root!=null){
            stack.push(root);
            if(root.left!=null)
                root = root.left;
            else
                break;
        }
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node.right;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        return node.val;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */