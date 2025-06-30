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
    long sum;
    long max;
    public int maxProduct(TreeNode root) {
        int mod = 1000000007;
        max=0;
        sum = findTreeSum(root);
        findTreeSum(root);
        return (int)(max%mod);
    }
    long findTreeSum(TreeNode root){
        if(root==null)
            return 0;
        long left = findTreeSum(root.left);
        long right= findTreeSum(root.right);
        long subTreeSum  =root.val + left + right;
        max = Math.max(max , (sum - subTreeSum)*subTreeSum);
        return subTreeSum;
    }

}