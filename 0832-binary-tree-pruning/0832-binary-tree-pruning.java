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
    public TreeNode pruneTree(TreeNode root) {
        if(root.left!=null)
            root.left = pruneTree(root.left);
        if(root.right!=null)
            root.right = pruneTree(root.right);
        if(root.right==root.left && root.val==0)
            return null;
        return root;
    }
}