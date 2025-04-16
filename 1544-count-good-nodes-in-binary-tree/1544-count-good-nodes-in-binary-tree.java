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
    int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        helper(root , Integer.MIN_VALUE);
        return ans;
    
    }
    void helper(TreeNode node , int val){
        if(node==null)
            return;
        if(node.val >=val){
            ans++;
            val = node.val;
        }
        helper(node.left , val);
        helper(node.right , val);
    }
}