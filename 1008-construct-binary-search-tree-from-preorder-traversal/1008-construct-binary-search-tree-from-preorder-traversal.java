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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length==0)
            return null;
        Stack<TreeNode> stack  =new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1 ; i<preorder.length ; i++){
            TreeNode node = new TreeNode(preorder[i]);
            if(preorder[i]  < stack.peek().val)
                stack.peek().left = node;
            else{
                TreeNode par = stack.peek();
                while(!stack.isEmpty() && preorder[i] > stack.peek().val)
                    par = stack.pop();
                par.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}