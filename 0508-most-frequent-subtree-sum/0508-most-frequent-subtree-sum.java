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
    HashMap<Integer , Integer> hmap = new HashMap<Integer , Integer>();
    int max=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        List<Integer> ans = new ArrayList<>();
        for(int sum : hmap.keySet()){
            if(hmap.get(sum)==max)
                ans.add(sum);
        }
        return ans.stream().mapToInt(i->i).toArray();
        
    }
    int helper(TreeNode node){
        if(node==null)
            return 0;
        int left = helper(node.left);
        int right  = helper(node.right);
        int sum = left + right + node.val;

        hmap.put(sum , hmap.getOrDefault(sum , 0)+1);
        max  = Math.max(max , hmap.get(sum));
        return sum;
    }
}