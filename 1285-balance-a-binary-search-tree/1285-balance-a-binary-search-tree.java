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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root , sorted);
        return createBst(sorted, 0 , sorted.size()-1);
    }
    void inorder(TreeNode node , List<Integer> sorted){
        if(node==null)
            return;
        inorder(node.left , sorted);
        sorted.add(node.val);
        inorder(node.right , sorted);
    }
    TreeNode createBst(List<Integer> sorted, int start , int end){
        if(start >end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(sorted.get(mid));
        root.left  = createBst(sorted , start , mid-1);
        root.right = createBst(sorted  , mid+1 , end);
        return root;

    }
}