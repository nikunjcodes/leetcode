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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root , ans , new ArrayList<>() , 0 , targetSum);
        return ans;
    }
    void helper(TreeNode node , List<List<Integer>> ans , List<Integer> temp , int currSum , int target){
        if(node ==null)
            return;     
        temp.add(node.val);
        currSum+=node.val;
        if(currSum == target && node.left ==null && node.right==null)
            ans.add(new ArrayList<>(temp));
        else{
        helper(node.left , ans , temp , currSum , target);
        helper(node.right , ans , temp , currSum , target);
        }
        temp.remove(temp.size() - 1);

        
        
    }
}