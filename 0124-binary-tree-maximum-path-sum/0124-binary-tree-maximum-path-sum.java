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
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    int helper(TreeNode root){
        if(root==null)
            return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        leftSum = leftSum > 0  ? leftSum : 0;
        rightSum = rightSum >0 ? rightSum : 0;
        ans = Math.max(ans , Math.max(root.val , (leftSum + rightSum + root.val)));
        return root.val + Math.max(leftSum , rightSum);
    }
}