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
    public TreeNode findNode(TreeNode root , int start ){
        if(root==null)
            return null;
        if(root.val == start)
            return root;
        TreeNode left = findNode(root.left , start);
        if(left!=null)
            return left;
        return findNode(root.right , start);
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null)
            return 0;

        Map<TreeNode  , List<TreeNode>> map = new HashMap<>();
        buildGraph(map , root , null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> set= new HashSet<>();
        int ans=0;
        q.add(findNode( root , start));
        set.add(start);
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.poll();
                for(TreeNode nodes : map.get(curr)){
                    if(!set.contains(nodes.val)){
                    q.add(nodes);
                    set.add(nodes.val);
                    }
                }
            }
        }
        return ans-1;
    }
    void buildGraph(Map<TreeNode , List<TreeNode>> map, TreeNode node , TreeNode parent){
            if(node==null)
                return;
            if(!map.containsKey(node))
                map.put(node , new ArrayList<>());
            if(parent!=null){
                map.get(parent).add(node);
                map.get(node).add(parent);
            }
            buildGraph(map , node.left , node);
            buildGraph(map , node.right , node);
    }
}