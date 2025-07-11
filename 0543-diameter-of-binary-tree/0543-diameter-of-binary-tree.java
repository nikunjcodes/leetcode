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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        if(root==null)
            return 0;
         helper(root);
        return ans;
    }
    int helper(TreeNode root){
        if(root==null)
            return 0;
        int left= helper(root.left);
        int right =helper(root.right);
        ans = Math.max(ans , left+right);
        return 1 + Math.max(left ,right);
    }
}