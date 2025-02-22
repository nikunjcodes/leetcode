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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal , 0);
    }
    TreeNode helper(String s , int depth){
        int dash=0;
        while(i + dash < s.length() && s.charAt(i+dash)=='-')
            dash++;
        if(dash!=depth)
            return null;
        int next = i + dash;
        while(next < s.length() && s.charAt(next)!='-')
            next++;
        int temp = Integer.parseInt(s.substring(i+dash, next));
        i = next;
        TreeNode root = new TreeNode(temp);
        root.left = helper(s, depth+1);
        root.right = helper(s,depth+1);
        return root;
    }
}