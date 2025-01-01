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
    TreeNode prev=null , one=null , two = null;
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        helper(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
        
    }
    void helper(TreeNode node){
        if(node == null)
            return;
        helper(node.left);
        if(prev!=null && node.val < prev.val){
            if(one==null)
                one=prev;
            two = node;
        }
        prev = node;
        helper(node.right);
        

    }
}