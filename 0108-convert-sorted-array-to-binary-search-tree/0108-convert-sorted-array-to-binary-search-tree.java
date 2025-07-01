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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums , 0 , nums.length-1);        
    }
    TreeNode buildTree(int [] nums, int left , int right){
        if(left > right || right>=nums.length  || left==-1 || right==-1)
            return null;
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode leftR = buildTree(nums , left , mid-1);
        TreeNode rightR= buildTree(nums , mid+1 , right);
        node.left = leftR;
        node.right = rightR;
        return node;

    }
}