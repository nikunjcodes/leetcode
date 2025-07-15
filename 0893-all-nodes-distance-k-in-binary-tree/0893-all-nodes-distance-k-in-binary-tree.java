/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void buildMap(Map<TreeNode , List<TreeNode>> map , TreeNode node , TreeNode parent){
        if(node==null)
            return ;
        if(!map.containsKey(node))
            map.put(node , new ArrayList<>());
        if(parent!=null){
            map.get(node).add(parent);
            map.get(parent).add(node);
        }
        buildMap(map  , node.left, node);
        buildMap(map , node.right , node);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , List<TreeNode>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        buildMap(map  , root , null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set= new HashSet<>();
        queue.add(target);
        int dist=0;
        while(!queue.isEmpty()){
            
            int size=queue.size();
            for(int i=0 ; i<size ; i++){
            
            if(dist ==k){
                for(TreeNode node : queue){
                ans.add(node.val);
                }
                            return ans;

            }
                TreeNode node = queue.poll();

                set.add(node);
                for(TreeNode neigh : map.get(node)){
                    if(!set.contains(neigh)){
                        queue.add(neigh);
                    }
                }
            }
        dist++;
        }
        return ans;
    }
}