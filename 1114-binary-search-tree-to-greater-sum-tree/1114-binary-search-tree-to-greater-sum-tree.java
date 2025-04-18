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
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return null;
        helper(root);
        return root;
    }
    void helper(TreeNode node){
        if(node==null)
            return ;
        helper(node.right);
        node.val = node.val + sum;
        sum = node.val;
        helper(node.left);
    }
}