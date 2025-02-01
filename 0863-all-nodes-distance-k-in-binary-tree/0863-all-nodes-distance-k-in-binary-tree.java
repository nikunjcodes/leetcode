/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    Map<TreeNode , Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new LinkedList<>();
        helper(root ,  target);
        dfs(root , target , k , map.get(root) , ans);      
        return ans; 
    }
    int helper(TreeNode root , TreeNode target){
        if(root==null)
            return -1;
        if(root==target){
            map.put(root,0);
            return 0;
        }
        int l = helper(root.left , target);
        if(l>=0){
            map.put(root , l+1);
            return l+1;
        }
        int r = helper(root.right , target);
        if(r>=0){
            map.put(root, r+1);
            return r+1;
        }
        return -1;
    }
    void dfs(TreeNode root , TreeNode target , int k , int length , List<Integer> ans){
        if(root==null)
            return;
        if(map.containsKey(root))
            length = map.get(root);
        if(length ==k)
            ans.add(root.val);
        dfs(root.left , target , k , length+1 , ans);
        dfs(root.right, target , k , length+1 , ans);
    }
}