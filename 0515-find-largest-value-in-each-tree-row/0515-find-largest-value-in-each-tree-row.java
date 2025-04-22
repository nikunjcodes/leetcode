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
    List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        ans = new ArrayList<>();
        bfs(root);
        return ans;
    }
    void bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0 ; i<size ; i++){
                TreeNode temp = queue.poll();
                if(temp.val > max)
                    max = temp.val;
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            ans.add(max);
        }
    }
}