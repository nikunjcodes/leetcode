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
    public TreeNode helper(Map<Integer , Integer> map , int[] inorder , int[] postOrder , int left , int right , int[] postIdx){
        if(left  > right)
            return null;
        int curr = postOrder[postIdx[0]];
        postIdx[0]--;
        TreeNode node = new TreeNode(curr);
        if(left==right)
            return node;
        int idx = map.get(curr);
            node.right = helper(map , inorder , postOrder , idx+1 , right ,  postIdx);

        node.left =  helper(map , inorder , postOrder , left, idx-1 , postIdx);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++)
            map.put(inorder[i]  , i);
        int[] postIdx = new int[]{postorder.length-1};
        return helper(map , inorder , postorder , 0  , inorder.length -1 ,  postIdx);
    }
}