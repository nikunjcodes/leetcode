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
    public int rob(TreeNode root) {
        int[] num = helper(root);
        return Math.max(num[0]  , num[1]);
    }
    int[] helper(TreeNode node){
        if(node ==null)
            return new int[2];
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] ans = new int[2];
        ans[0] = left[1] + right[1] + node.val;
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0] , right[1]);
        return ans;
    }
}