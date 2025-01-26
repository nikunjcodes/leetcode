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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer , TreeNode> map =  new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        for(int[] arr : descriptions){
            int parent = arr[0] , child  = arr[1] , left = arr[2];
            nodes.add(child);
            TreeNode node = map.getOrDefault(parent , new TreeNode(parent));
            if(left ==1 ){
                node.left= map.getOrDefault(child , new TreeNode(child));
                map.put(child , node.left);
            }
            else{
                node.right = map.getOrDefault(child , new TreeNode(child));
                map.put(child , node.right);
            }
            map.put(parent , node);
        }
        int root = -1 ;
        for(int[] arr : descriptions){
            if(!nodes.contains(arr[0])){
                root = arr[0];
                break;
                  }
                        }
            return map.getOrDefault(root , null);

    }
}