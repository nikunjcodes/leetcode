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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0 ; i<size ; i++){
            TreeNode t = q.poll();
            if(flag){
                   temp.addLast(t.val); 
            }
            else
                temp.addFirst(t.val);
            if(t.left!=null)
                q.add(t.left);
            if(t.right!=null)
                q.add(t.right);
            }
            ans.add(temp);
            flag = !flag;

        }
        return ans;
    }
}