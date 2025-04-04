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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).getValue();
    }
    public Pair<Integer , TreeNode> helper(TreeNode root){
        if(root==null)
            return new Pair(0,null);
        Pair<Integer, TreeNode> left = helper(root.left) , right=  helper(root.right);
        int d1 = left.getKey();
        int d2 = right.getKey();
        return new Pair(Math.max(d1,d2)+1 , d1==d2 ? root : d1 > d2 ? left.getValue() : right.getValue());
    }
}