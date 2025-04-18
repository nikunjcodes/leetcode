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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getAllElements(list1 , root1);
        getAllElements(list2,  root2);
        List<Integer> ans = new  ArrayList<>();
        int i=0 , j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) <list2.get(j)){
                ans.add(list1.get(i));
                i++;
            }
            else{
                ans.add(list2.get(j++));
            }
        }
        while(i<list1.size()){
            ans.add(list1.get(i++));
        }
        while(j<list2.size()){
            ans.add(list2.get(j++));
        }
        return ans;

    }
    void getAllElements(List<Integer> list , TreeNode root){
        if(root==null)
            return;
        getAllElements(list , root.left);
        list.add(root.val);
        getAllElements(list , root.right);
    }
}