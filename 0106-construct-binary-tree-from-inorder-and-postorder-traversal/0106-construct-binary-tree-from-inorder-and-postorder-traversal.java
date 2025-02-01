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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(inorder , 0 , inorder.length-1 , postorder , 0 , postorder.length-1);
    }
    TreeNode helper(int[] inorder ,int inStart , int inEnd , int[] postorder , int postStart , int postEnd){
        if(inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx =0;
        for(int i=inStart ; i<=inEnd ; i++){
            if(inorder[i]== root.val){
                idx=i;
                break;
            }
        }
        root.left = helper(inorder , inStart , idx-1 , postorder, postStart , postStart + idx - inStart -1);
        root.right = helper(inorder , idx+1 , inEnd , postorder , postEnd -inEnd + idx , postEnd-1);
        return root;
    }
}