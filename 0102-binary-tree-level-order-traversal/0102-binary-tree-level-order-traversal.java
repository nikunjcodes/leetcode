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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> temp = new ArrayList<>();
        while (q.size() > 1) {
            TreeNode t = q.remove();
            if (t == null) {
                ans.add(new ArrayList<>(temp));
                temp.clear();
                q.add(null);
            } else {
                temp.add(t.val);
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                }
            }
        ans.add(new ArrayList<>(temp));
        return ans;
    }
}