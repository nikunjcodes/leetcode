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
    Map<Integer , Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0 ; i<postorder.length ; i++)
            postMap.put(postorder[i]  , i);
        return helper(0 , preorder.length-1 , 0 , preorder.length , preorder , postorder);
    }
    TreeNode helper(int preL , int preR , int postL , int postR , int[] pre , int[]post){
        if(preL > preR || postL >postR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        if(preL + 1 <=preR){
            int index = postMap.get(pre[preL+1]);
            int sum = index - postL;
            root.left = helper(preL+1  , preL+sum+1 , postL , postL+sum, pre , post);
            root.right = helper(preL+sum+2  , preR , postL  + sum+1, postR-1, pre , post);
        }
        return root;
    }
}