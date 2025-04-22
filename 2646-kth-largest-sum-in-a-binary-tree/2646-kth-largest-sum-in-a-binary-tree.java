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
    public long kthLargestLevelSum(TreeNode root, int k) {
       
        List<Long> sum = new ArrayList<>();
        bfs(root , sum);
        Collections.sort(sum , Collections.reverseOrder());
        if(k>sum.size())
            return -1;
        return sum.get(k-1);

    }
    void bfs(TreeNode root , List<Long> sum){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            long temp=0;
            for(int i=0 ; i<size ; i++){
                TreeNode node = queue.poll();
                temp += node.val;
                if(node.left!=null)
                queue.offer(node.left);
                if(node.right!=null)
                queue.offer(node.right);

            }
            sum.add(temp);
        }
    }
}