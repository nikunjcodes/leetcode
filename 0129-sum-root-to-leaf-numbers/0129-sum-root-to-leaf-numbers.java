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
            int totalSum=0;

    public int sumNumbers(TreeNode root) {
        int currSum=0;
        helper(root  , currSum );
        return totalSum;
    }
    void helper(TreeNode root , int currSum ){
        if(root == null)
            return;
        currSum = currSum*10 + root.val;
        if(root.left == null && root.right ==null){
            totalSum += currSum;
            return ;
        }
        helper(root.left , currSum );
        helper(root.right , currSum );
    }


}