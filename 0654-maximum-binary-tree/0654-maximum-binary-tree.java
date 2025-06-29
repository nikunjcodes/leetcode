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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums , 0 , nums.length-1);
    }
    TreeNode helper(int[] nums , int left , int right){
        if(left>right)
            return null;
        int max = getMax(nums , left , right);
        TreeNode root = new TreeNode(nums[max]);
        TreeNode leftRoot = helper(nums , left ,max-1);
        TreeNode rightRoot = helper(nums  , max+1 , right);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
    int getMax(int[] nums , int left, int right){
        int max=0;
        int ans=left;
        for(int i=left ; i<=right  ; i++){
            if(nums[i] > max){
                max= nums[i];
                ans=i;
            }
        }
        return ans;
    }
}