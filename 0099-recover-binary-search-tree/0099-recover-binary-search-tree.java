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
    TreeNode prev , one , two;
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        prev= null;
        one = null;
        two  = null;
        helper(root);
        int temp = one.val;
        one.val = two.val;
        two.val  = temp;
        return;
    }
    void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        if(prev!=null && root.val < prev.val){
            if(one==null)
                one = prev;
            two = root;
        }
        prev = root;
        helper(root.right);
    }
}