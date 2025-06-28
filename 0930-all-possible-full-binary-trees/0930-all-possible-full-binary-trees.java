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
    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n);
    }
    List<TreeNode> helper(int n){
        List<TreeNode> ans = new ArrayList<>();
        if(n==0)
            return ans;
        if(n==1){
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i=1 ; i<n ; i++){
            List<TreeNode> left =helper(i);
            List<TreeNode> right =helper(n-i-1);
        for(TreeNode l : left){
            for(TreeNode r : right){
                TreeNode node = new TreeNode(0);
                node.right = r;
                node.left = l;
                ans.add(node);
            }
        }

    }
                    return ans;

    }
}