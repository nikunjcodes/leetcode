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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();
        inorder(root1  , inorder1);
        inorder(root2 , inorder2);
        return merge(inorder1 , inorder2);
    }
    void inorder(TreeNode node , List<Integer> list){
        if(node==null)
            return;
        inorder(node.left , list);
        list.add(node.val);
        inorder(node.right , list);
    }
    List<Integer> merge(List<Integer> list1 , List<Integer> list2){
        List<Integer> ans  = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) > list2.get(j)){
                ans.add(list2.get(j++));
            }
            else
                ans.add(list1.get(i++));
        }
        while(i<list1.size()){
            ans.add(list1.get(i++));
        }
        while(j<list2.size())
            ans.add(list2.get(j++));
        return ans;
    }
}