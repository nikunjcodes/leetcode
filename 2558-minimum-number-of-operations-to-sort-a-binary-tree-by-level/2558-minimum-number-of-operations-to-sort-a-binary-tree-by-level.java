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
    public int minimumOperations(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] arr = new int[size];
            for(int i=0 ;  i<size ; i++){
                TreeNode node = queue.poll();
                arr[i] = node.val;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);

            }
            ans+=helper(arr);
        }
        return ans;
    }
    int helper(int[] arr){
        int swaps=0;
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++ ){
            map.put( arr[i] , i);
        }
        for(int i=0 ; i<arr.length ; i++){
            if(clone[i]!=arr[i]){
                swaps++;
                int curr = map.get(clone[i]);
                map.put(arr[i] , curr);
                arr[curr] = arr[i];
            }
        }
        return swaps;
    }
}