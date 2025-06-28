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
        int ans=0;

    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return 0;
        helper(root , false , false);
        return ans;
    }
    void helper(TreeNode root , boolean parent , boolean gp){
        if(root==null)
            return;
        if(gp)
            ans+=root.val;
        if(root.val%2==0){
            helper(root.left ,true , parent);
            helper(root.right ,true , parent);
        }
        else{
            helper(root.left ,false , parent);
            helper(root.right ,false , parent);
        }
    }
}