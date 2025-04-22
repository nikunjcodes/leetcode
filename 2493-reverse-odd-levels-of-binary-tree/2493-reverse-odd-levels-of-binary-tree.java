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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root ==null)
            return null;
        dfs(root);
        return root;
    }
    void dfs(TreeNode root){
        int level=0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>();
            for(int i=0 ; i<size ; i++){
                
                TreeNode node = q.poll();
               if(level%2==1) 
                    nodes.add(node);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
                
            }
            if(level%2==1){
            int left=0 , right = nodes.size()-1;
            while(left < right){
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;
                    left++;
                    right--;
            }
            }
            level++;
        }

    }
}